package com.example.covidtracker

import com.google.gson.annotations.SerializedName

data class CovidData(
    @SerializedName("dateChecked") val dateChecked: String,

)