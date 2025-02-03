//package com.example.myapplication.data
//
//import android.util.Log
//import io.ktor.client.HttpClient
//import io.ktor.client.plugins.HttpTimeout
//import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
//import io.ktor.client.plugins.defaultRequest
//import io.ktor.client.plugins.logging.LogLevel
//import io.ktor.client.plugins.logging.Logger
//import io.ktor.client.plugins.logging.Logging
//import io.ktor.client.request.accept
//import io.ktor.http.ContentType
//import io.ktor.http.contentType
//import io.ktor.serialization.kotlinx.json.json
//import kotlinx.serialization.json.Json
//
//object KtorClient {
//
//    private val json = Json {
//        encodeDefaults = true
//        ignoreUnknownKeys = true
//
//    }
//
//    // http client
//    val httpClient = HttpClient(){
//
//        // json 설정 3.X 버전
//        install(ContentNegotiation) {
//            json(json)
//        }
//
//        // logging 설정
//        install(Logging) {
//            logger = object : Logger {
//                override fun log(message: String) {
//                    Log.d("TAG", "$message")
//                }
//            }
//            level = LogLevel.ALL
//        }
//
//        install(HttpTimeout) {
//            requestTimeoutMillis = 5000
//            connectTimeoutMillis = 1000
//            socketTimeoutMillis = 1000
//        }
//
//        // 기본적인 api 호출 시 넣는 것들, 즉 기본 세팅
//        defaultRequest {a
//            contentType(ContentType.Application.Json)
//            accept(ContentType.Application.Json)
//        }
//    }
//
//
//
//}