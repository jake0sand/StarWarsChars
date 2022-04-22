package com.jakey.starwarsimages.domain.model

data class Character(
    val id: Int? = 0,
    val birth_year: String,
    val films: List<String>,
    val species: List<String>,
    val gender: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val image: String
)