package com.mtjin.presentation.di.core

import com.mtjin.presentation.views.login.LoginComponent
import com.mtjin.presentation.views.search.MovieSearchComponent
import com.mtjin.presentation.views.splash.SplashComponent
import dagger.Module

@Module(subcomponents = [SplashComponent::class, LoginComponent::class, MovieSearchComponent::class])
class AppSubComponentsModule