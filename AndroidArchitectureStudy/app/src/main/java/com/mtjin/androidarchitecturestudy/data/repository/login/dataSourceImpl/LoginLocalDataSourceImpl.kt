package com.mtjin.androidarchitecturestudy.data.repository.login.dataSourceImpl

import com.mtjin.androidarchitecturestudy.data.repository.login.dataSource.LoginLocalDataSource
import com.mtjin.androidarchitecturestudy.presention.utils.PreferenceManager

class LoginLocalDataSourceImpl(private val preferenceManager: PreferenceManager) :
    LoginLocalDataSource {
    override var autoLogin: Boolean
        get() = preferenceManager.autoLogin
        set(value) {
            preferenceManager.autoLogin = value
        }
}