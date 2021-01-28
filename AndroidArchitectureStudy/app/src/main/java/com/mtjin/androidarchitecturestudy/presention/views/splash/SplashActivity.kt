package com.mtjin.androidarchitecturestudy.presention.views.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mtjin.androidarchitecturestudy.R
import com.mtjin.androidarchitecturestudy.presention.views.login.LoginActivity
import com.mtjin.androidarchitecturestudy.presention.views.search.MovieSearchActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

open class SplashActivity : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
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
