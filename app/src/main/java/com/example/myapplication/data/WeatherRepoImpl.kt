package com.example.myapplication.data

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class WeatherRepoImpl(private val client: KtorClient) : WeatherRepo {

    companion object {
        private const val url = "https://api.openweathermap.org/data/2.5/weather"
        private const val apiKey = "f95329a0af797206caba4c9965932edb"
    }

    override suspend fun getWeather(city: String ) : WeatherResponse {

        return client.httpClient.get(url) {
            parameter("q", city)
            parameter("appid", apiKey)
            parameter("units", "metric") // 섭씨 온도
            parameter("lang", "kr") // 한국어
        }.body()
    }

    override suspend fun getWeatherByCoordinates(lat: Double, lon: Double): WeatherResponse {
        return client.httpClient.get(url) {
            parameter("lat", lat)
            parameter("lon", lon)
            parameter("appid", apiKey)
            parameter("units", "metric")
            parameter("lang", "kr")
        }.body()
    }

}