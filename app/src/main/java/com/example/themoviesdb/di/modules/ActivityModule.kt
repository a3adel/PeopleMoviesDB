package com.example.themoviesdb.di.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.themoviesdb.di.ActivityContext
import dagger.Module
import dagger.Provides
@Module
class ActivityModule(val activity: AppCompatActivity){
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): AppCompatActivity = activity
}