package com.mtjin.data.repository.login.local

import com.mtjin.data.utils.PreferenceManager


class LoginLocalDataSourceImpl(private val preferenceManager: PreferenceManager) :
    LoginLocalDataSource {
    override var autoLogin: Boolean
        get() = preferenceManager.autoLogin
        set(value) {
            preferenceManager.autoLogin = value
        }
}