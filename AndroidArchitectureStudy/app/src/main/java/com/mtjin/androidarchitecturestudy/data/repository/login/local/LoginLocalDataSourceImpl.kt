package com.mtjin.androidarchitecturestudy.data.repository.login.local

import com.mtjin.androidarchitecturestudy.utils.PreferenceManager

class LoginLocalDataSourceImpl(private val preferenceManager: PreferenceManager) :
    LoginLocalDataSource {
    override var autoLogin: Boolean
        get() = preferenceManager.autoLogin
        set(value) {
            preferenceManager.autoLogin = value
        }
}