package com.example.myapplication.data

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

interface WeatherRepo {
    suspend fun getWeather(city: String) : WeatherResponse
    suspend fun getWeatherByCoordinates(lat: Double, lon: Double): WeatherResponse


}