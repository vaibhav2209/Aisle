package com.example.aisle.application

import android.content.Context
import com.example.aisle.utils.network.KtorHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideKtorClient() : HttpClient =
        KtorHttpClient.ktorClient

    @Singleton
    @Provides
    fun provideSessionManager(
        @ApplicationContext app: Context
    ) : SessionManager =
        SessionManager(app)
}