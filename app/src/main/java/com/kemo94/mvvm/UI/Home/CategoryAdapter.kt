package com.kemo94.mvvm.UI.Home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import java.util.ArrayList
import com.kemo94.mvvm.Data.Model.CategoryModel
import com.kemo94.revivaltask.R
import com.squareup.picasso.Picasso


class CategoryAdapter(var data: ArrayList<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_category, null)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.bind(data.get(position))

    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.banner_imv)
        lateinit var bannerImv: ImageView

        @BindView(R.id.name_txv)
        lateinit var nameTxv: TextView

        @BindView(R.id.icon_imv)
        lateinit var iconImv: ImageView

        private var data: CategoryModel? = null

        init {
            ButterKnife.bind(this, itemView)

        }

        fun bind(data: CategoryModel) {
            this.data = data

            nameTxv.text = data.name

            Picasso.get()
                    .load(data.banner)
                    .resize(500,500)
                    .placeholder(R.drawable.placeholder)
                    .into(bannerImv)

            Picasso.get()
                    .load(data.icon)
                    .into(iconImv)

        }
    }
}
