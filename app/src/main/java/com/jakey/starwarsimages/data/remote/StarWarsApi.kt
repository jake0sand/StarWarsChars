package com.jakey.starwarsimages.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApi {

    @GET("people/")
    suspend fun getAllCharacter(@Query("page") page: Int): Response<AllCharacterDto>

    @GET("people/{id}/")
    suspend fun getCharacterById(@Path("id") id: Int): Response<CharacterDto>

//    @GET("planets/{id}")
//    suspend fun getPlanet(@Path("id") id: Int): Response<PlanetDto>
//
    @GET("species/{id}")
    suspend fun getSpecies(@Path("id") id: Int): Response<SpeciesDto>

}