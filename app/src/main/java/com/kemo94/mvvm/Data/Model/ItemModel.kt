package com.kemo94.mvvm.Data.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(
        var id: Int = 0,
        var name: String? = "",
        var banner: String? = "",
        var icon: String? = ""
) : Parcelable

@Parcelize
data class BrandModel(
        var id: Int = 0,
        var image: String? = ""
) : Parcelable