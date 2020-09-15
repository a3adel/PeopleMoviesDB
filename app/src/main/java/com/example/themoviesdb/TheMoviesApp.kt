package com.example.themoviesdb

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDexApplication
import com.example.themoviesdb.data.RemoteDataSource
import com.example.themoviesdb.di.components.AppComponent
import com.example.themoviesdb.di.components.DaggerAppComponent
import com.example.themoviesdb.di.modules.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TheMoviesApp: MultiDexApplication(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initDagger()
    }


    open fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    companion object {
        lateinit var context: Context
    }
}