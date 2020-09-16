package com.rbs.mymvvmtemplate.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rbs.mymvvmtemplate.R
import com.rbs.mymvvmtemplate.models.MealsItem
import com.rbs.mymvvmtemplate.models.MealsResponse
import com.rbs.mymvvmtemplate.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mealsItem: ArrayList<MealsItem> = arrayListOf()
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()
        setData()
    }

    private fun initialization() {
        rv_meals.setHasFixedSize(true)
        rv_meals.layoutManager = GridLayoutManager(this, 2)
        mainAdapter = MainAdapter(mealsItem, this)
        rv_meals.adapter = mainAdapter
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun setData() {
        mainViewModel.getData().observe(this,
            Observer<MealsResponse> { response ->
                val listMealsItem = response.meals
                mealsItem.addAll(listMealsItem)
                rv_meals.adapter?.notifyDataSetChanged()
            })
        mainAdapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MealsItem) {
                startActivity(
                    Intent(this@MainActivity, DetailActivity::class.java)
                        .putExtra(DetailActivity.MEALS_ID, data.idMeal)
                )
            }
        })
    }
}