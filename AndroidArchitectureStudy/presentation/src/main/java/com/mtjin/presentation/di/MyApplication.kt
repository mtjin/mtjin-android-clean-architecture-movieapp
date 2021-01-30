package com.mtjin.presentation.di

import android.app.Application
import com.mtjin.presentation.di.core.AppComponent
import com.mtjin.presentation.di.core.DaggerAppComponent

class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        //initializeComponent()
        DaggerAppComponent.factory().create(this)
    }
}