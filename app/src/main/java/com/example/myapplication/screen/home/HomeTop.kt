package com.example.myapplication.screen.home

import android.content.Context
import android.graphics.fonts.FontStyle
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Clouds
import com.example.myapplication.data.Crood
import com.example.myapplication.data.Main
import com.example.myapplication.data.Sys
import com.example.myapplication.data.Weather
import com.example.myapplication.data.WeatherResponse
import com.example.myapplication.data.WeatherViewModel
import com.example.myapplication.data.Wind
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.FusedLocationProviderClient

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeTop(
    viewModel : WeatherViewModel,
) {

    val weatherState by viewModel.weather.collectAsState()
    Log.d("HomeTop", "현재 날씨 상태: $weatherState")

    LaunchedEffect(Unit) {
        viewModel.weatherByLocation()
    }







    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Text(text = weatherState?.name ?: "Loading...", fontSize = 20.sp)

        Text(text = "${weatherState?.main?.temp ?: "--"}°C", fontSize = 35.sp)

        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text = "최고: ${weatherState?.main?.temp_max}", fontSize = 10.sp)
            Text(text = "최저: ${weatherState?.main?.temp_min}", fontSize = 10.sp)
        }
    }
}

