package com.kemo94.mvvm.UI.Home

import android.app.Activity
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kemo94.mvvm.Data.Model.BrandModel
import com.kemo94.mvvm.Data.Model.CategoryModel
import com.kemo94.revivaltask.R
import com.squareup.picasso.Picasso


class BrandAdapter(internal var activity: Activity, var data: ArrayList<BrandModel>) : PagerAdapter() {


    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        var layoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.row_brand, null)
        val imageView = view.findViewById(R.id.banner_imv) as ImageView

        Picasso.get()
                .load(data.get(position).image)
                .resize(500,500)
                .into(imageView)

        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, i: Int, obj: Any) {
        container.removeView(obj as View)
    }
}
