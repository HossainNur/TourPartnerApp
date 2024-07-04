package com.seip.android.tourmatestarterapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

const val weather_api_key = "0ac8a6ac495d018dab257fd7be5456d3"
const val base_url = "https://api.openweathermap.org/data/2.5/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface WeatherServiceApi {

}

object WeatherApi {

}

