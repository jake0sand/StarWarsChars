package com.jakey.starwarsimages.data.remote

import java.io.Serializable

data class CharacterDto(
    val url: String,
    val id: Int? = 0,
    val birth_year: String,
    val films: List<String> = listOf(),
    val species: List<String> = listOf(),
    val gender: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val image: String? = null
)



