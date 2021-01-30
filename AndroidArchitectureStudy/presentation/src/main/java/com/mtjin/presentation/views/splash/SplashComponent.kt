package com.mtjin.presentation.views.splash

import com.mtjin.presentation.di.core.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface SplashComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    fun inject(splashActivity: SplashActivity)
}