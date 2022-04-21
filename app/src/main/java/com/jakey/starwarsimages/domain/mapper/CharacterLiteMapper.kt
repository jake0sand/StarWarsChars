package com.jakey.starwarsimages.domain.mapper

import com.jakey.starwarsimages.data.remote.CharacterDto
import com.jakey.starwarsimages.data.remote.ImageUrls
import com.jakey.starwarsimages.domain.model.CharacterLite
import com.jakey.starwarsimages.utils.HelperFuns2
import javax.inject.Inject

class CharacterLiteMapper @Inject constructor(
    private val imageUrls: ImageUrls,
    private val helperFuns2: HelperFuns2
) {
    fun buildFrom(characterDto: CharacterDto): CharacterLite {
        val id = helperFuns2.lastSegment(characterDto.url)
        return CharacterLite(
            id = id,
            name = characterDto.name,
            imageUrl = imageUrls.map[id]!!,
            birthYear = characterDto.birth_year
        )
    }
}
