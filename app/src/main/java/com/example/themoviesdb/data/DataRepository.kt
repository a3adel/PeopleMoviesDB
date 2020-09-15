package com.example.themoviesdb.data

import com.example.themoviesdb.data.models.People
import com.example.themoviesdb.data.models.PersonImages
import com.example.themoviesdb.data.models.PersonProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(
    private val remoteDataManager: RemoteDataManager,
    private val ioDispatcher: CoroutineContext
) : DataRepositorySource {
    override suspend fun getPeople(): Flow<Resource<People>> {
        return flow {
            emit(remoteDataManager.getPeople())
        }.flowOn(ioDispatcher)
    }

    override suspend fun getPersonImages(id:String): Flow<Resource<PersonImages>> {
        return flow {
            emit(remoteDataManager.getPersonImages(id))
        }.flowOn(ioDispatcher)
    }
}