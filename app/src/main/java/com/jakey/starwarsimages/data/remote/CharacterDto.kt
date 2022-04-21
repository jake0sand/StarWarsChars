package com.jakey.starwarsimages.data.remote

import android.os.Parcelable
import com.jakey.starwarsimages.utils.HelperFuns.lastSegment
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class CharacterDto(
    val url: String,
    val id: String = lastSegment(url),
    val birth_year: String,
    val films: List<String> = listOf(),
    val species: List<String> = listOf(),
    val gender: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    val name: String,
    val image: String = imageUrl.images[id.toInt() - 1]
) : Serializable

val imageUrl = ImageUrls()

