package com.example.themoviesdb.di.modules

import com.example.themoviesdb.data.DataRepository
import com.example.themoviesdb.data.DataRepositorySource
import com.example.themoviesdb.data.RemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepo(appDataManager: DataRepository): DataRepositorySource
}