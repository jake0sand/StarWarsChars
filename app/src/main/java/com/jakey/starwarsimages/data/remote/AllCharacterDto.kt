package com.jakey.starwarsimages.data.remote



data class AllCharacterDto(
    val count: Int,
    val next: String,
    val previous: Any? = null,
    val results: List<CharacterDto>
)