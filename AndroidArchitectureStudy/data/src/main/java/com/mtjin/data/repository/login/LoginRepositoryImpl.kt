package com.mtjin.data.repository.login

import com.mtjin.data.repository.login.local.LoginLocalDataSource
import com.mtjin.domain.repository.LoginRepository

class LoginRepositoryImpl(private val loginLocalDataSource: LoginLocalDataSource) :
    LoginRepository {

    override var autoLogin: Boolean
        get() = loginLocalDataSource.autoLogin
        set(value) {
            loginLocalDataSource.autoLogin = value
        }
}