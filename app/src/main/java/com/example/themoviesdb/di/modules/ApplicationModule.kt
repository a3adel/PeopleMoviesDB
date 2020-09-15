package com.example.themoviesdb.di.modules

import android.app.Application
import android.content.Context
import com.example.currencyconverter.ui.utils.NetworkConnectivity
import com.example.currencyconverter.ui.utils.NetworkUtils
import com.example.themoviesdb.TheMoviesApp

import com.example.themoviesdb.data.RemoteDataSource
import com.example.themoviesdb.di.ApplicationContext
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class ApplicationModule() {
    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideNetworkConnectivity(): NetworkConnectivity {
        return NetworkUtils(TheMoviesApp.context)
    }

}