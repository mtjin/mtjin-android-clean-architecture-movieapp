package com.mtjin.presentation.di.core

import androidx.lifecycle.ViewModel
import com.mtjin.presentation.views.login.LoginViewModel
import com.mtjin.presentation.views.search.MovieSearchViewModel
import com.mtjin.presentation.views.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieSearchViewModel::class)
    abstract fun bindMovieSearchViewModel(movieSearchViewModel: MovieSearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel
}