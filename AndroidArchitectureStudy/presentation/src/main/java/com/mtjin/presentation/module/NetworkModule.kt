package com.mtjin.presentation.module

import com.mtjin.presentation.utils.NetworkManager
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single { NetworkManager(get()) }
}