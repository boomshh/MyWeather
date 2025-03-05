package com.example.myapplication.data

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient

class ViewModelFactory(
    private val repository: WeatherRepo,
    private val locationClient: FusedLocationProviderClient,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(repository, locationClient, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
