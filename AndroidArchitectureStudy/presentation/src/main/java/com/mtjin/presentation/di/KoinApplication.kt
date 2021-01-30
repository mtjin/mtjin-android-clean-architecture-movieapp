package com.mtjin.presentation.di

import android.app.Application
import com.mtjin.presentation.module.*
import com.mtjin.presentation.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger()
            } else {
                androidLogger(Level.ERROR)
            }
            androidContext(this@KoinApplication)
            modules(
                repositoryModule,
                localDataModule,
                remoteDataModule,
                networkModule,
                viewModelModule,
                apiModule,
                useCaseModule
            )

        }
    }


}