package com.jakey.starwarsimages.domain.mapper

import com.jakey.starwarsimages.data.remote.CharacterDto
import com.jakey.starwarsimages.data.remote.ImageUrls
import com.jakey.starwarsimages.domain.model.Character
import com.jakey.starwarsimages.utils.HelperFuns2
import javax.inject.Inject


class CharacterMapper @Inject constructor(
    private val imageUrls: ImageUrls,
    private val helperFuns2: HelperFuns2
) {
    fun buildFrom(characterDto: CharacterDto): Character {
        val id = helperFuns2.lastSegment(characterDto.url)
        return Character(
            id = id,
            name = characterDto.name,
            image = imageUrls.map[id]!!,
            birth_year = characterDto.birth_year,
            gender = characterDto.gender,
            homeworld = characterDto.homeworld,
            species = characterDto.species,
            height = characterDto.height,
            mass = characterDto.mass,
            films = characterDto.films
        )
    }
}

