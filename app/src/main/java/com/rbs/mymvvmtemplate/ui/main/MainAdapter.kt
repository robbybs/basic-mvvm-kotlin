package com.rbs.mymvvmtemplate.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rbs.mymvvmtemplate.R
import com.rbs.mymvvmtemplate.models.MealsItem
import kotlinx.android.synthetic.main.item_meals.view.*

class MainAdapter(private val listMeals: List<MealsItem?>?, private val context: Context) :
    RecyclerView.Adapter<MainAdapter.GridViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_meals, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = listMeals?.size!!

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        listMeals?.get(position)?.let { holder.bind(it) }
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(meals: MealsItem) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(meals.strMealThumb)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)
            }
            itemView.setOnClickListener { onItemClickCallback?.onItemClicked(meals) }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MealsItem)
    }
}