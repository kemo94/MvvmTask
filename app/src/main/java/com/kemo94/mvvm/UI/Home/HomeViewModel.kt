package com.kemo94.mvvm.UI.Home

import android.arch.lifecycle.ViewModel
import com.kemo94.mvvm.Data.Service.HomeRepository


class HomeViewModel(var listener: HomeLoadingListener) : ViewModel() {


    private var homeRepository: HomeRepository? = null


    init {
        homeRepository = HomeRepository()
    }


    fun fetchBrands(page: Int) {
        listener.onBrandsLoaded(homeRepository!!.getBrands(page))
    }

    fun fetchCategories(page: Int) {
        listener.onCategoriesLoaded(homeRepository!!.getCategories(page))
    }
}