package com.mtjin.presentation.di.core

import android.content.Context
import com.mtjin.presentation.di.data.ApiModule
import com.mtjin.presentation.di.data.LocalDataModule
import com.mtjin.presentation.di.data.RemoteDataModule
import com.mtjin.presentation.di.data.RepositoryModule
import com.mtjin.presentation.views.login.LoginComponent
import com.mtjin.presentation.views.search.MovieSearchComponent
import com.mtjin.presentation.views.splash.SplashComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ViewModelModule::class, ViewModelFactoryModule::class, AppSubComponentsModule::class, LocalDataModule::class, RepositoryModule::class,
        RemoteDataModule::class, ApiModule::class]
)
interface AppComponent {
    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun loginComponent(): LoginComponent.Factory

    fun movieSearchComponent(): MovieSearchComponent.Factory

    fun splashComponent(): SplashComponent.Factory
}