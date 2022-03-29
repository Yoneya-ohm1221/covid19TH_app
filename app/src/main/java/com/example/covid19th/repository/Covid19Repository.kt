package com.example.covid19th.repository

import com.example.covid19th.model.Covid
import com.example.covid19th.model.CovidAllItem
import com.example.covid19th.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class Covid19Repository
@Inject
constructor(private val apiService: ApiService){

    suspend fun getCovid():Response<List<Covid>>{
        return  apiService.getAllCovid()
    }

    suspend fun getAllCovid():Response<List<CovidAllItem>>{
        return apiService.getTotalCovid()
    }

}