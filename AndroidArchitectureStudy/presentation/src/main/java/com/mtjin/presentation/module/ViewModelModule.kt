package com.mtjin.presentation.module

import com.mtjin.presentation.views.login.LoginViewModel
import com.mtjin.presentation.views.search.MovieSearchViewModel
import com.mtjin.presentation.views.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { SplashViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { MovieSearchViewModel(get(), get(), get(), get()) }
}