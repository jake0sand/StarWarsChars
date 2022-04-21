package com.jakey.starwarsimages.domain.model

data class CharacterLite(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val birthYear: String
)
