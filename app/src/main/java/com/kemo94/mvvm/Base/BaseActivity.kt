package com.kemo94.mvvm.Base

import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

open class BaseActivity : AppCompatActivity() {

    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
        ButterKnife.bind(this)
    }
}