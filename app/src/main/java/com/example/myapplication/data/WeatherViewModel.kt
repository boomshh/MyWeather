package com.example.myapplication.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepo) : ViewModel()  {

    private val _weather = MutableStateFlow<WeatherResponse?>(null)
    val weather: StateFlow<WeatherResponse?> get() = _weather

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                _weather.value = repository.getWeather(city)
            } catch( e: Exception) {
                e.printStackTrace()
            }
        }
    }


}