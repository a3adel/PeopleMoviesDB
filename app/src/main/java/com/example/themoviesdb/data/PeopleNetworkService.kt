package com.example.themoviesdb.data

import com.example.themoviesdb.data.models.PeopleImagesResponse
import com.example.themoviesdb.data.models.PeopleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleNetworkService {
    @GET("3/person/popular?api_key=166d823124931341b391456bdfe81f76")
    suspend fun getPeople(): Response<PeopleResponse>

    @GET("3/person/{person_id}/images?api_key=166d823124931341b391456bdfe81f76")
    suspend fun getPersonImages(@Path("person_id") personId: String):Response<PeopleImagesResponse>
}