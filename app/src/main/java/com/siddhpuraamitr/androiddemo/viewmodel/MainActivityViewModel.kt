package com.siddhpuraamitr.androiddemo.viewmodel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.siddhpuraamitr.androiddemo.model.Fact
import com.siddhpuraamitr.androiddemo.model.FactRepository

class MainActivityViewModel(@NonNull application: Application) :
    AndroidViewModel(application) {

    private val factRepository: FactRepository = FactRepository()

    fun getFact(): LiveData<Fact> {
        return factRepository.getMutableLiveData()
    }

}