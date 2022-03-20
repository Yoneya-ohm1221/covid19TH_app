package com.example.covid19th.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19th.model.Covid
import com.example.covid19th.repository.Covid19Repository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CovidViewModel
@Inject
constructor(private val repository: Covid19Repository) :ViewModel(){

    val _covid = MutableLiveData<List<Covid>>()
    val  covid :LiveData<List<Covid>?>
          get() = _covid
    init {
        viewModelScope.launch {
            val res = repository.getCovid()
            if (res.isSuccessful){
                _covid.value = res.body()
            }
        }
    }

}