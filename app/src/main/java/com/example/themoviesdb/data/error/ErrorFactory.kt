package com.example.themoviesdb.data.error

interface ErrorFactory {
    fun getError(errorCode: Int): Error
}
