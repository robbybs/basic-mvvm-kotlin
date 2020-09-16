package com.rbs.mymvvmtemplate.ui.detail

import androidx.lifecycle.MutableLiveData
import com.rbs.mymvvmtemplate.models.MealsResponse
import com.rbs.mymvvmtemplate.utils.ApiRequest
import com.rbs.mymvvmtemplate.utils.RetrofitRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRepository {
    private var service: ApiRequest = RetrofitRequest.getService()

    fun getDetailMeal(mealsId: String?): MutableLiveData<MealsResponse> {
        val mealsData: MutableLiveData<MealsResponse> = MutableLiveData()
        mealsId?.let {
            service.getMealsById(it).enqueue(object : Callback<MealsResponse> {
                override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<MealsResponse>,
                    response: Response<MealsResponse>
                ) {
                    mealsData.value = response.body()
                }
            })
        }
        return mealsData
    }
}