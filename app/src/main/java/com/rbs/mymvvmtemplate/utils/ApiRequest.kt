package com.rbs.mymvvmtemplate.utils

import com.rbs.mymvvmtemplate.models.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("filter.php?c=Seafood")
    fun getMeals(): Call<MealsResponse>
    @GET("lookup.php")
    fun getMealsById(@Query("i") id: String): Call<MealsResponse>
}