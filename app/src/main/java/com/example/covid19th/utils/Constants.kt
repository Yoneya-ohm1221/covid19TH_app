package com.example.covid19th.utils

import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val BASE_URL ="https://covid19.ddc.moph.go.th/api/"
    val DATE_NOW = getCurrentDate()
    private fun getCurrentDate():String{
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        return sdf.format(Date())
    }
}

