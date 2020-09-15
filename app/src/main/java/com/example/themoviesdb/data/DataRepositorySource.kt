package com.example.themoviesdb.data

import com.example.themoviesdb.data.models.People
import com.example.themoviesdb.data.models.PersonImages
import com.example.themoviesdb.data.models.PersonProfile
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun getPeople(): Flow<Resource<People>>
    suspend fun getPersonImages(id:String): Flow<Resource<PersonImages>>

}