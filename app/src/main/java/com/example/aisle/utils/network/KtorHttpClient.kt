package com.example.aisle.utils.network

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object KtorHttpClient {


    private const val TIME_OUT = 60_000
    const val TAG = "KtorClient =>"


    val ktorClient = HttpClient(Android) {

        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }

        install(ContentNegotiation) {
            json(
                json = Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                },
                contentType = ContentType.Application.Json
            )
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v(TAG, message)
                }

            }
            level = LogLevel.ALL
        }

        defaultRequest {
            url(ApiEndPoint.BASE_URL)
            contentType(ContentType.Application.Json)
        }

    }

}