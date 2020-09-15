package com.example.themoviesdb.data

import com.example.currencyconverter.ui.utils.NetworkConnectivity
import com.example.themoviesdb.data.error.NETWORK_ERROR
import com.example.themoviesdb.data.error.NO_INTERNET_CONNECTION
import com.example.themoviesdb.data.models.*
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteDataManager @Inject constructor(
    private val apiService: APIService,
    private val networkConnectivity: NetworkConnectivity
) : RemoteDataSource {
    override suspend fun getPeople(): Resource<People> {
        val peopleService = apiService.createService(PeopleNetworkService::class.java)
        return when (val response = processCall { peopleService.getPeople() }) {
            is PeopleResponse -> {
                Resource.Success(data = People(response.people))
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun getPersonImages(personId: String):Resource<PersonImages> {
        val peopleService = apiService.createService(PeopleNetworkService::class.java)
        return when (val response = processCall(personId, peopleService::getPersonImages)) {
            is PeopleImagesResponse -> {
                Resource.Success(data = PersonImages(response.profiles))
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }

    }

    private suspend fun processCall(

        responseCall: suspend () -> Response<*>
    ): Any? {

        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }

    private suspend fun processCall(
        asd: String,
        responseCall: suspend (asd: String) -> Response<*>
    ): Any? {

        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke(asd)
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}