package com.example.covid19th.model


import com.google.gson.annotations.SerializedName

data class CovidAllItem(
    @SerializedName("new_case")
    val newCase: String,
    @SerializedName("new_case_excludeabroad")
    val newCaseExcludeabroad: String,
    @SerializedName("new_death")
    val newDeath: String,
    @SerializedName("new_recovered")
    val newRecovered: String,
    @SerializedName("total_case")
    val totalCase: String,
    @SerializedName("total_case_excludeabroad")
    val totalCaseExcludeabroad: String,
    @SerializedName("total_death")
    val totalDeath: String,
    @SerializedName("total_recovered")
    val totalRecovered: String,
    @SerializedName("txn_date")
    val txnDate: String,
    @SerializedName("update_date")
    val updateDate: String
)