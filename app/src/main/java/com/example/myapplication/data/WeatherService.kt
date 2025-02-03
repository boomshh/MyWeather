//package com.example.myapplication.data
//
//import io.ktor.client.call.body
//import io.ktor.client.request.get
//import io.ktor.client.request.parameter
//
//class WeatherService {
//
//    suspend fun getWeather(city: String, apiKey: String ) : WeatherResponse {
//        val url = "https://api.openweathermap.org/data/2.5/weather"
//        return KtorClient.httpClient.get(url) {
//            parameter("q", city)
//            parameter("appid", apiKey)
//            parameter("units", "metric") // 섭씨 온도
//            parameter("lang", "kr") // 한국어
//        }.body()
//    }
//}