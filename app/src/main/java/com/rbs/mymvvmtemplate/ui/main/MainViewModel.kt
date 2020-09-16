package com.rbs.mymvvmtemplate.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rbs.mymvvmtemplate.models.MealsResponse

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var data: MutableLiveData<MealsResponse>

    init {
        val mainRepository = MainRepository()
        this.data = mainRepository.getData()
    }

    fun getData(): MutableLiveData<MealsResponse> = data
}