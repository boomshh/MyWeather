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

        return KtorClient.httpClient.get(url) {
            parameter("q", city)
            parameter("appid", apiKey)
            parameter("units", "metric") // 섭씨 온도
            parameter("lang", "kr") // 한국어
        }.body()
    }

}