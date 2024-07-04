package com.nurhossain.tourpartnerapp.viewmodels

import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurhossain.tourpartnerapp.model.CurrentWeatherModel
import com.nurhossain.tourpartnerapp.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val TAG = "WeatherViewModel"
    private val repository = WeatherRepository()
    private val _currentData = MutableLiveData<CurrentWeatherModel>()

    var tempStatus = false

    val current: LiveData<CurrentWeatherModel>
        get() = _currentData


    fun getWeatherData(location: Location) {

    }
}