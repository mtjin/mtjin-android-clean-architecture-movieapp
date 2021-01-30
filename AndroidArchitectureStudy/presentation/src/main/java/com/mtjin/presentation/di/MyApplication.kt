package com.mtjin.presentation.di

import android.app.Application
import com.mtjin.presentation.di.core.AppComponent

class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        //initializeComponent()
        DaggerAppComponent.factory().create(this)
    }
}