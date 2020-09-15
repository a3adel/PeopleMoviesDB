package com.example.themoviesdb.data.error

import com.example.themoviesdb.TheMoviesApp
import javax.inject.Inject

class ErrorMapper @Inject constructor() : ErrorMapperInterface {

    override fun getErrorString(errorId: Int): String {
        return TheMoviesApp.context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, ("Please check your internet connection")),
            Pair(NETWORK_ERROR, "Network error, could get data,please try again!")

        ).withDefault { "Network error, could get data,please try again!" }
}
