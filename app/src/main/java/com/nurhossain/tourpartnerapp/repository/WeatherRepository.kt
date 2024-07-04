package com.nurhossain.tourpartnerapp.repository

import android.location.Location
import com.nurhossain.tourpartnerapp.model.CurrentWeatherModel

class WeatherRepository {

    suspend fun fetchCurrentData(location: Location, tempStatus: Boolean) : CurrentWeatherModel?{
        return null
    }

}