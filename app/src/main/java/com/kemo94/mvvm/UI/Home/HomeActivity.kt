package com.kemo94.mvvm.UI.Home

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.OnClick
import com.kemo94.mvvm.Base.BaseActivity
import com.kemo94.mvvm.Data.Model.BrandModel
import com.kemo94.mvvm.Data.Model.CategoryModel
import com.kemo94.mvvm.Util.ApiModule
import com.kemo94.revivaltask.R


class HomeActivity : BaseActivity(), HomeLoadingListener {


    @BindView(R.id.categories_recycler)
    lateinit var categoriesRecycler: RecyclerView

    @BindView(R.id.brands_pager)
    lateinit var brandsPager: ViewPager

    lateinit var brandAdapter: BrandAdapter
    lateinit var categoryAdapter: CategoryAdapter

    lateinit var homeViewModel: HomeViewModel

    var brandsArray = ArrayList<BrandModel>()

    var categoriesArray = ArrayList<CategoryModel>()

    var categoriesPage = 0
    var brandsPage = 0
    var isBrandsFull = false
    var isCategoriesFull = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeViewModel = HomeViewModel(this)
        brandAdapter = BrandAdapter(this, brandsArray)
        categoryAdapter = CategoryAdapter(categoriesArray)

        setupRecyclerView()
        setupPagerView()


        homeViewModel.fetchBrands(0)
        homeViewModel.fetchCategories(0)
    }

    fun setupPagerView() {
        brandsPager.adapter = brandAdapter

        brandsPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (!isBrandsFull && (position + 1) >= ApiModule.limit)
                    homeViewModel.fetchBrands(brandsPage)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    fun setupRecyclerView() {

        val gridLayoutManager = GridLayoutManager(this, 2)
        categoriesRecycler.layoutManager = gridLayoutManager
        categoriesRecycler.setHasFixedSize(true)
        categoriesRecycler.adapter = categoryAdapter

        categoriesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = gridLayoutManager.getChildCount()
                val totalItemCount = gridLayoutManager.getItemCount()
                val firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition()

                if (!isCategoriesFull) {
                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                            && firstVisibleItemPosition >= 0
                            && totalItemCount >= ApiModule.limit) {
                        homeViewModel.fetchCategories(categoriesPage)

                    }
                }
            }
        })
    }

    override fun onCategoriesLoaded(categories: ArrayList<CategoryModel>) {
        categoriesArray.addAll(categories)
        categoryAdapter.notifyDataSetChanged()
        categoriesPage++

        if (categoriesPage > categoriesArray.size)
            isCategoriesFull = true

    }

    override fun onBrandsLoaded(brands: ArrayList<BrandModel>) {
        brandsArray.addAll(brands)
        brandAdapter.notifyDataSetChanged()
        brandsPage++

        if (brandsPage > brands.size)
            isBrandsFull = true

    }

    @OnClick(R.id.next_imv)
    fun onClickNext() {

        if (brandsPager.currentItem < brandsArray.size - 1)
            brandsPager.currentItem++
        else
            brandsPager.currentItem = 0

    }

    @OnClick(R.id.prev_imv)
    fun onClickPrev() {
        if (brandsPager.currentItem > 0)
            brandsPager.currentItem--
        else
            brandsPager.currentItem = brandsArray.size - 1
    }
}