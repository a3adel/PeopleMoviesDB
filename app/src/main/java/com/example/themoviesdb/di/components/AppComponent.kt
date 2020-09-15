package com.example.themoviesdb.di.components

import com.example.themoviesdb.TheMoviesApp
import com.example.themoviesdb.di.modules.ApplicationModule
import com.example.themoviesdb.di.modules.DataModule
import com.example.themoviesdb.di.modules.ViewModelModules
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ApplicationModule::class,
        DataModule::class,
        ActivityModuleBuilder::class
        , ViewModelModules::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: TheMoviesApp)

}