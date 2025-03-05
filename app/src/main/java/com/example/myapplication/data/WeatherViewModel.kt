package com.example.myapplication.data

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class WeatherViewModel(private val repository: WeatherRepo,
    private val loacationClient: FusedLocationProviderClient,
    private val context: Context
) : ViewModel()  {

    private val _weather = MutableStateFlow<WeatherResponse?>(null)
    val weather: StateFlow<WeatherResponse?> get() = _weather

    @SuppressLint("MissingPermission")
    fun weatherByLocation() {
        viewModelScope.launch {
            try {
                val location = getLastKnownLocation()
                if (location != null) {
                    val weatherResponse = repository.getWeatherByCoordinates(
                        location.latitude, location.longitude
                    )
                    _weather.value = weatherResponse
                } else {
                    Log.e("WeatherViewModel", "위치를 가져올 수 없습니다")
                }
            } catch (e: Exception) {
                Log.e("WeatherViewModel", "날씨 데이터를 가져오는 중 오류 발생: ${e.message}")
            }
        }
    }

    @SuppressLint("MissingPermission")
    private suspend fun getLastKnownLocation(): Location? {
        return suspendCoroutine { continuation ->
            if (ContextCompat.checkSelfPermission(
                    context, Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Log.e("WeatherViewModel", "위치 권한이 없습니다")
                continuation.resume(null)
                return@suspendCoroutine
            }

            loacationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    continuation.resume(location)
                } else {
                    Log.e("WeatherViewModel", "위치 정보가 없습니다. 새로 요청합니다.")
                    val locationRequest = com.google.android.gms.location.LocationRequest.create().apply {
                        priority = com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
                        interval = 5000 // 5초마다 갱신
                    }

                    loacationClient.requestLocationUpdates(
                        locationRequest,
                        object : com.google.android.gms.location.LocationCallback() {
                            override fun onLocationResult(result: com.google.android.gms.location.LocationResult) {
                                loacationClient.removeLocationUpdates(this)
                                if (result.locations.isNotEmpty()) {
                                    continuation.resume(result.locations[0])
                                } else {
                                    continuation.resume(null)
                                }
                            }
                        },
                        null
                    )
                }
            }.addOnFailureListener {
                Log.e("WeatherViewModel", "위치를 가져오는 중 오류 발생: ${it.message}")
                continuation.resume(null)
            }
        }
    }










}