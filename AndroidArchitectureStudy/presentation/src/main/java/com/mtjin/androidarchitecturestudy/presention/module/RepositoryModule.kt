package com.mtjin.androidarchitecturestudy.presention.module

import com.mtjin.androidarchitecturestudy.domain.repository.LoginRepository
import com.mtjin.androidarchitecturestudy.data.repository.login.LoginRepositoryImpl
import com.mtjin.androidarchitecturestudy.domain.repository.MovieRepository
import com.mtjin.androidarchitecturestudy.data.repository.search.MovieRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
}