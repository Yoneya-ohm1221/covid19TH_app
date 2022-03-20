package com.example.covid19th.network

import com.example.covid19th.model.Covid
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("Cases/today-cases-by-provinces")
    suspend  fun getAllCovid() : Response<List<Covid>>
}