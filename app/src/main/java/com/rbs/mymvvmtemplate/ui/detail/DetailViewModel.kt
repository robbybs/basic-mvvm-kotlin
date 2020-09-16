package com.rbs.mymvvmtemplate.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rbs.mymvvmtemplate.models.MealsResponse

class DetailViewModel(application: Application, parameter: String?) : AndroidViewModel(application) {
    private var data: MutableLiveData<MealsResponse>

    init {
        val detailRepository = DetailRepository()
        this.data = detailRepository.getDetailMeal(parameter)
    }

    fun getData(): MutableLiveData<MealsResponse> = data
}