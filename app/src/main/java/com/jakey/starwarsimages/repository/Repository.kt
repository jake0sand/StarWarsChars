package com.jakey.starwarsimages.repository

import com.jakey.starwarsimages.data.remote.StarWarsApi
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: StarWarsApi
) {
    suspend fun getCharacters(page: Int) = api.getAllCharacter(page)

}