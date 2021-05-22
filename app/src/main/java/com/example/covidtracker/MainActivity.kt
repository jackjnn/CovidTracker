package com.example.covidtracker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

private const val BASE_URL = "https://covidtracking.com/api/v1/"
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var nationalDailyData: List<CovidData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("todo")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val covidService = retrofit.create(CovidService::class.java)
        //fetch the national data
            covidService.getNationalData().enqueue(object: Callback<List<CovidData>>,
                retrofit2.Callback<List<CovidData>> {
                override fun onResponse(
                    call: Call<List<CovidData>>,
                    response: Response<List<CovidData>>
                ) {
                    Log.i(TAG, "onResponse $response")
                    val nationalData = response.body()
                    if (nationalData == null) {
                        Log.w(TAG, "Did not receive a valid response body")
                        return
                    }
                    nationalDailyData = nationalData.reversed()
                    Log.i(TAG, "Update graph with national data")
                    // TODO: Update graph with national data
                }

                override fun onFailure(call: Call<List<CovidData>>, t: Throwable) {
                    Log.e(TAG, "onFailure $t")
                }

            })

        //fetch the state data

    }
}