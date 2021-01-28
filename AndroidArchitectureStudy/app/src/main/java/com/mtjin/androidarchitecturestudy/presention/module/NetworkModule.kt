package com.mtjin.androidarchitecturestudy.presention.module

import com.mtjin.androidarchitecturestudy.utils.NetworkManager
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single { NetworkManager(get()) }
}