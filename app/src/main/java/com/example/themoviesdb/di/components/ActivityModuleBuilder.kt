package com.example.themoviesdb.di.components

import com.example.themoviesdb.ui.details.PersonDetailsActivity
import com.example.themoviesdb.ui.people.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
@Module
abstract class ActivityModuleBuilder {
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeDetailsActivity(): PersonDetailsActivity
}