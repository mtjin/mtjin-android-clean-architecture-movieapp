package com.mtjin.androidarchitecturestudy.presention.module

import com.mtjin.androidarchitecturestudy.presention.views.login.LoginViewModel
import com.mtjin.androidarchitecturestudy.presention.views.search.MovieSearchViewModel
import com.mtjin.androidarchitecturestudy.presention.views.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { SplashViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { MovieSearchViewModel(get(), get(), get(), get()) }
}