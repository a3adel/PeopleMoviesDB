package com.example.themoviesdb.data

import com.example.themoviesdb.data.models.People
import com.example.themoviesdb.data.models.PersonImages

interface RemoteDataSource {
    suspend fun getPeople(): Resource<People>
    suspend fun getPersonImages(personId: String):Resource<PersonImages>
}