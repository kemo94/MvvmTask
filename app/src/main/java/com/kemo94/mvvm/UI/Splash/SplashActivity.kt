package com.kemo94.mvvm.UI.Splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.kemo94.mvvm.Base.BaseActivity
import com.kemo94.revivaltask.R
import com.kemo94.mvvm.UI.Home.HomeActivity
import com.kemo94.mvvm.UI.Home.HomeViewModel

open class SplashActivity : BaseActivity(), SplashListener {

    lateinit var splashViewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        splashViewModel = SplashViewModel(this)

    }

    override fun onLoadingFinish() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}