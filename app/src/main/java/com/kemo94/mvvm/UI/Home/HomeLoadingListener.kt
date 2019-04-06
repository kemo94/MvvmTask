package com.kemo94.mvvm.UI.Home

import com.kemo94.mvvm.Data.Model.BrandModel
import com.kemo94.mvvm.Data.Model.CategoryModel


interface HomeLoadingListener {

    fun onCategoriesLoaded(categories: ArrayList<CategoryModel>)
    fun onBrandsLoaded(brands: ArrayList<BrandModel>)
}