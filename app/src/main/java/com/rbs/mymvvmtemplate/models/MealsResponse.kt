package com.rbs.mymvvmtemplate.models

import com.google.gson.annotations.SerializedName

data class MealsResponse (
    @field:SerializedName("meals")
    val meals: List<MealsItem>
)