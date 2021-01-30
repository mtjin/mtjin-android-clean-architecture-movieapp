package com.mtjin.presentation.views.search

import com.mtjin.presentation.di.core.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MovieSearchComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSearchComponent
    }

    fun inject(movieSearchActivity: MovieSearchActivity)
}