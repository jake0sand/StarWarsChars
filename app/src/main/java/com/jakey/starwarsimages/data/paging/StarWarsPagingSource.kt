package com.jakey.starwarsimages.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jakey.starwarsimages.data.remote.CharacterDto
import com.jakey.starwarsimages.data.remote.StarWarsApi
import com.jakey.starwarsimages.domain.mapper.CharacterLiteMapper
import com.jakey.starwarsimages.domain.model.CharacterLite
import com.jakey.starwarsimages.repository.Repository
import java.lang.Exception

class StarWarsPagingSource(
    private val characterLiteMapper: CharacterLiteMapper,
    private val repository: Repository
) : PagingSource<Int, CharacterLite>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterLite>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterLite> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getCharacters(currentPage)
            val data = response?.body()?.results ?: emptyList()

            val characterLiteList = data.map {
                characterLiteMapper.buildFrom(it)
            }

            LoadResult.Page(
                data = characterLiteList,
                prevKey =  if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}