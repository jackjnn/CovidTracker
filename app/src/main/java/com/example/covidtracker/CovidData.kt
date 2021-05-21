package com.example.covidtracker

data class CovidData(
    val dateChecked: String,
    val positiveIncrease: String,
    val negativeIncrease: String,
    val deathIncrease: String,
    val state: String

)