package com.example.covidtracker

import com.robinhood.spark.SparkAdapter

class CovidSparkAdapter(private val dailyData: List<CovidData>) : SparkAdapter() {

    var metric = Metric.POSITIVE
    var daysAgo = TimeScale.MAX

    override fun getY(index: Int): Float {
        val chosenDayData = dailyData[index]
        return when (metric) {
            Metric.NEGATIVE -> chosenDayData.negativeIncrease.toFloat()
            Metric.POSITIVE -> chosenDayData.positiveIncrease.toFloat()
            Metric.DEATH -> chosenDayData.deathIncrease.toFloat()
        }
        return chosenDayData.positiveIncrease.toFloat()
    }

    override fun getItem(index: Int) = dailyData[index]

    override fun getCount() = dailyData.size





}
