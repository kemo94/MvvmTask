package com.kemo94.mvvm.Data.Service

import com.kemo94.mvvm.Data.Model.BrandModel
import com.kemo94.mvvm.Data.Model.CategoryModel
import com.kemo94.mvvm.Util.ApiModule

class HomeService {
    var categoriesDB = ArrayList<CategoryModel>()
    var brandsDB = ArrayList<BrandModel>()

    init{
        setCategoriesData()
        setBrandsData()
    }
    fun getCategories(page: Int): ArrayList<CategoryModel> {
        var categories = ArrayList<CategoryModel>()
        var i = page * ApiModule.limit
        while (i < ApiModule.limit * (page + 1) && i < categoriesDB.size) {
            categories.add(categoriesDB.get(i))
            i++
        }
        return categories
    }

    fun getBrands(page: Int): ArrayList<BrandModel> {
        var brands = ArrayList<BrandModel>()
        var i = page * ApiModule.limit
        while (i < ApiModule.limit * (page + 1) && i < brandsDB.size) {
            brands.add(brandsDB.get(i))
            i++
        }
        return brands
    }

    fun setCategoriesData(): ArrayList<CategoryModel> {
        var id = 1
        categoriesDB.add(CategoryModel(id++, "مياه", "https://thumbs.dreamstime.com/z/fresh-cold-wate-4581838.jpg", "https://image.flaticon.com/icons/png/512/227/227154.png"))
        categoriesDB.add(CategoryModel(id++, "شاي", "https://www.twinings.co.uk/app_/responsive/TwiningsUKI/media/content/About-Tea/shutterstock_126275183.jpg?w=1060", "https://cdn.iconscout.com/icon/premium/png-256-thumb/coffee-cup-hot-drink-plate-shop-tea-4-61614.png"))
        categoriesDB.add(CategoryModel(id++, "طحينة", "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcQ1aV_QVpyDVaQlaydOZcqeeE71Iytc0J9KIg_pxr0STmOn3zsJ", "https://image.flaticon.com/icons/png/128/135/135406.png"))
        categoriesDB.add(CategoryModel(id++, "منظفات", "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcRd0ZGVJbWi9QG3Y4OMKuGAgLkgfQudqu2l9x7rsXgPZWZItdAc", "https://image.flaticon.com/icons/png/128/995/995053.png"))
        categoriesDB.add(CategoryModel(id++, "العناية الشخصية", "http://3.bp.blogspot.com/-Swd6pj3MLu0/VqLOUmy6D3I/AAAAAAAABQ4/LOV0Ai8EqHs/s1600/%25D8%25A7%25D9%2584%25D9%2586%25D8%25B3%25D8%25AE%25D9%2587IMG_7221.JPG", "https://cdn.iconscout.com/icon/premium/png-256-thumb/body-care-3-1084131.png"))
        categoriesDB.add(CategoryModel(id++, "بهارات", "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcRJWxr6GW3c_smE4OItVyMGpdMmdv3Z-PUOScH1lytSync_N-dc", "https://image.flaticon.com/icons/png/128/1368/1368605.png"))
        categoriesDB.add(CategoryModel(id++, "مكرونة", "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcTH-f-D1qcdKFx5FxHRIL5xXmg09sLGXEw6OD4rAejrKVr0Bf_6", "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcRzQ_4fNQxGBq9UXpySTUooegogZyH3ZKDoKGW15fN_gVuXZTq2"))
        categoriesDB.add(CategoryModel(id++, "مشروبات", "https://img.youm7.com/large/20161010024508458.jpg", "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcRK6KAl3ie_nEQNBqBJCuhOhCenLm23KSeOSnSTZo3K0j_GSOPG"))
        categoriesDB.add(CategoryModel(id++, "تسالي", "https://brands-na.ssl-brands-amazon.com/brands/I/718a3c7nVKL._SY355_.jpg", "https://image.flaticon.com/icons/png/128/81/81107.png"))
        return categoriesDB
    }

    fun setBrandsData(): ArrayList<BrandModel> {
        var id = 1
        brandsDB.add(BrandModel(id++, "https://www.kerrygroup.com/consumer-foods/our-customer-brands/Customer-Logos.jpg"))
        brandsDB.add(BrandModel(id++, "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcRXH9qjiPrLpjBZZ7YDYkAAfzALDGB5M6-QUsnvh_M0Z9qkBbUJ"))
        brandsDB.add(BrandModel(id++, "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcSB3vlbEApdd5_tBeSnUJSerKUk1ONwOUR2ozlLEXwU_sUheK5j"))
        brandsDB.add(BrandModel(id++, "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcQbXBm_k4MEcXVb05gKJU1ReOXpYWXPdRlM9FHDn5N6cmhYAWmq"))
        brandsDB.add(BrandModel(id++, "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcRpwzXw90GWawd8LdmrYQjymhZZMzXLmumi_dJaay3StzJlQyxN"))
        brandsDB.add(BrandModel(id++, "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcTordJGAVo0CpGQZO2EA8wL6tp56ob4brbe2vBS20WaEWSnqWMs"))
        brandsDB.add(BrandModel(id++, "https://encrypted-tbn0.gstatic.com/brands?q=tbn:ANd9GcTAwiykjZq8WesylCejGyPPkfgmHmTeh5eP2tlAvQKuowYe7MoY"))
        return brandsDB
    }
}