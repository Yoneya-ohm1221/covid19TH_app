package com.example.covid19th.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19th.model.Covid
import com.example.covid19th.model.CovidAllItem
import com.example.covid19th.repository.Covid19Repository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CovidViewModel
@Inject
constructor(private val repository: Covid19Repository) :ViewModel(){


    private val _covid = MutableLiveData<List<Covid>>()
    val  covid :LiveData<List<Covid>?> = _covid

      fun allCovid(){
        viewModelScope.launch(Dispatchers.IO) {
                val res = repository.getCovid()
                if (res.isSuccessful){
                    _covid.postValue(res.body())
            }
        }
    }

    fun refreshCovid(){
        viewModelScope.launch(Dispatchers.IO) {
            while (true){
                val res = repository.getCovid()
                if (res.isSuccessful){
                    _covid.postValue(res.body())
                }
                delay(5000)
            }
        }
    }

    private val _totalCovid = MutableLiveData<List<CovidAllItem>>()
    val totalCovid :LiveData<List<CovidAllItem>> = _totalCovid

     fun  getTotalCovid(){
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getAllCovid()
            if (res.isSuccessful){
                _totalCovid.postValue(res.body())
            }
        }
    }


}