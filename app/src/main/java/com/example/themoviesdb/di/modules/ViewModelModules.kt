package com.example.themoviesdb.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themoviesdb.ViewModelFactory
import com.example.themoviesdb.di.ViewModelKey
import com.example.themoviesdb.ui.details.PersonDetailsViewModel
import com.example.themoviesdb.ui.people.PeopleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModules {
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
    @Binds
    @IntoMap
    @ViewModelKey(PeopleViewModel::class)
    internal abstract fun bindPeopleViewModel(viewModel: PeopleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonDetailsViewModel::class)
    internal abstract fun bindPersonDetailsViewModel(viewModel: PersonDetailsViewModel): ViewModel
}