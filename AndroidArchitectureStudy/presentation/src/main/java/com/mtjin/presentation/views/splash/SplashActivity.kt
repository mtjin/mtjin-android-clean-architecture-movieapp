package com.mtjin.presentation.views.splash

import MyApplication
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mtjin.presentation.R
import com.mtjin.presentation.views.login.LoginActivity
import com.mtjin.presentation.views.search.MovieSearchActivity
import javax.inject.Inject

open class SplashActivity : AppCompatActivity() {
    lateinit var splashComponent: SplashComponent

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SplashViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        splashComponent =
            (application as MyApplication).appComponent.splashComponent().create()
        splashComponent.inject(this)
        super.onCreate(savedInstanceState)
        initViewModelCallback()
        viewModel.doSplash()
    }

    private fun initViewModelCallback() {
        with(viewModel) {
            goMovieSearch.observe(this@SplashActivity, Observer {
                goMovieSearch()
            })
            goLogin.observe(this@SplashActivity, Observer {
                goLogin()
            })
        }
    }


    private fun goLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun goMovieSearch() {
        showToast(getString(R.string.auto_login_msg))
        startActivity(Intent(this, MovieSearchActivity::class.java))
        finish()
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
