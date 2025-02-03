package com.example.myapplication.screen.home

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.Clouds
import com.example.myapplication.data.Crood
import com.example.myapplication.data.Main
import com.example.myapplication.data.Sys
import com.example.myapplication.data.Weather
import com.example.myapplication.data.WeatherResponse
import com.example.myapplication.data.WeatherViewModel
import com.example.myapplication.data.Wind

@Composable
fun HomeTop(
    weather : WeatherResponse
) {

//    val weatherState by viewModel.weather.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Text(text = weather.name ?: "Loading...", fontSize = 20.sp)

        Text(text = "${weather?.main?.temp ?: "--"}°C", fontSize = 35.sp)

        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text = "최고: 18.", fontSize = 10.sp)
            Text(text = "최저: 3.", fontSize = 10.sp)
        }
    }
}

@Preview
@Composable
fun HomeTopPreview() {
    val dummyWeather = WeatherResponse(
        name = "Seoul",
        coord = Crood(lon = 126.97, lat = 37.56), // 좌표 추가
        weather = listOf(Weather(id = 800, main = "Clear", description = "맑음", icon = "01d")),
        main = Main(
            temp = 7.0,
            feels_like = 27.0,
            temp_min = 18.0,
            temp_max = 30.0,
            pressure = 1013,
            humidity = 65,
            sea_level = 1013,
            grnd_level = 1000
        ),
        wind = Wind(speed = 3.5, deg = 200), // 바람 데이터 추가
        clouds = Clouds(all = 0), // 구름 데이터 추가
        sys = Sys(type = 1, country = "KR", sunrised = 1678901234, sunset = 1678945678) // 시스템 데이터 추가
    )

    HomeTop(weather = dummyWeather)
}