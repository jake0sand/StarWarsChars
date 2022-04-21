package com.jakey.starwarsimages.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.jakey.starwarsimages.data.paging.StarWarsPagingSource
import com.jakey.starwarsimages.data.remote.AllCharacterDto
import com.jakey.starwarsimages.domain.mapper.CharacterLiteMapper
import com.jakey.starwarsimages.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
    characterLiteMapper: CharacterLiteMapper
): ViewModel() {

    private val _allCharactersLiveData = MutableLiveData<AllCharacterDto>()
    val allCharacterLiveData: LiveData<AllCharacterDto>
        get() = _allCharactersLiveData


    val listData = Pager(PagingConfig(10, prefetchDistance = 30)) {
        StarWarsPagingSource(characterLiteMapper, repository)
    }.flow.cachedIn(viewModelScope)

//    fun getCharacters(page: Int) =
//
//        viewModelScope.launch {
//            repository.getCharacters(page).let { response ->
//                if (response.isSuccessful) {
//                    _allCharactersLiveData.postValue(response.body())
//                } else {
//                    Log.d("response error", "getCharacters: ${response.code()}")
//                }
//            }
//        }
}