package com.example.covid19th.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Covid(
    @SerializedName("update_date")
    var update_date: String,
    @SerializedName("province")
    var province:String,
    @SerializedName("new_case")
    var new_case:String,
    @SerializedName("total_case")
    var total_case:String,
    @SerializedName("new_case_excludeabroad")
    var new_case_excludeabroad:String,
    @SerializedName("total_case_excludeabroad")
    var total_case_excludeabroad:String,
    @SerializedName("new_death")
    var new_death:String,
    @SerializedName("total_death")
    var total_death:String,
) : Parcelable
