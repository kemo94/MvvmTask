package com.kemo94.mvvm.UI.Splash

import android.arch.lifecycle.ViewModel
import android.os.Handler


class SplashViewModel(var listener: SplashListener) : ViewModel() {

    init {
        Handler().postDelayed({
            listener.onLoadingFinish()
        }, 2000)

    }

}