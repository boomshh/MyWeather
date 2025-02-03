package com.example.myapplication.data

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val coord : Crood,
    val weather : List<Weather>,
    val main: Main,
    val wind: Wind,
    val clouds: Clouds,
    val sys: Sys,
    val name: String
)

@Serializable
data class Crood (
    val lon: Double,
    val lat: Double
)

@Serializable
data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

@Serializable
data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int,
    val sea_level: Int,
    val grnd_level: Int
)

@Serializable
data class Wind(
    val speed: Double,
    val deg: Int
)

@Serializable
data class Clouds(
    val all: Int
)

@Serializable
data class Sys(
    val type : Int,
    val country: String,
    val sunrised: Long,
    val sunset: Long
)