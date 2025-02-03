//package com.example.myapplication.data
//
//import com.google.android.datatransport.runtime.dagger.Module
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    fun provideKtorClient() :KtorClient {
//        return KtorClient
//    }
//
//    fun provideWeatherRepo(client: KtorClient) : WeatherRepo {
//        return WeatherRepoImpl(client)
//    }
//
//}