package com.kemo94.mvvm.Data.Service

import com.kemo94.mvvm.Data.Model.BrandModel
import com.kemo94.mvvm.Data.Model.CategoryModel


class HomeRepository {

    var homeService: HomeService? = null

    fun getCategories(page: Int): ArrayList<CategoryModel> {
        if (homeService == null)
            homeService = HomeService()
        return homeService!!.getCategories(page)
    }

    fun getBrands(page: Int): ArrayList<BrandModel> {
        if (homeService == null)
            homeService = HomeService()
        return homeService!!.getBrands(page)
    }
}