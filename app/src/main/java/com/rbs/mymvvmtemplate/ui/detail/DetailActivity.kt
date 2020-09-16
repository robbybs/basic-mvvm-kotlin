package com.rbs.mymvvmtemplate.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rbs.mymvvmtemplate.R
import com.rbs.mymvvmtemplate.models.MealsResponse
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val MEALS_ID = "meals_id"
    }

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initialization()
        setData()
    }

    private fun initialization() {
        val mealsId: String? = intent.getStringExtra(MEALS_ID)
        detailViewModel =
            ViewModelProvider(this, DetailViewModelFactory(this.application, mealsId)).get(
                DetailViewModel::class.java
            )
    }

    private fun setData() {
        detailViewModel.getData().observe(this,
            Observer<MealsResponse> { response ->
                tv_mealName.text = response?.meals?.get(0)?.strMeal
            })
    }
}