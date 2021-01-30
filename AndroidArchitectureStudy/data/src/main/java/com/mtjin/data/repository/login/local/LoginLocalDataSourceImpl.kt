package com.mtjin.data.repository.login.local

import com.mtjin.data.utils.PreferenceManager
import javax.inject.Inject


class LoginLocalDataSourceImpl @Inject constructor(private val preferenceManager: PreferenceManager) :
    LoginLocalDataSource {
    override var autoLogin: Boolean
        get() = preferenceManager.autoLogin
        set(value) {
            preferenceManager.autoLogin = value
        }
}