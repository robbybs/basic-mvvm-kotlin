package com.rbs.mymvvmtemplate.ui.main

import androidx.lifecycle.MutableLiveData
import com.rbs.mymvvmtemplate.models.MealsResponse
import com.rbs.mymvvmtemplate.utils.ApiRequest
import com.rbs.mymvvmtemplate.utils.RetrofitRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    private var service: ApiRequest = RetrofitRequest.getService()

    fun getData(): MutableLiveData<MealsResponse> {
        val mealsData: MutableLiveData<MealsResponse> = MutableLiveData()
        service.getMeals().enqueue(object : Callback<MealsResponse> {
            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                mealsData.value = response.body()
            }
        })
        return mealsData
    }
}