package com.example.aisle.auth.di

import com.example.aisle.auth.data.remote.AuthApiImpl
import com.example.aisle.auth.data.remote.IAuthApi
import com.example.aisle.auth.data.repository.AuthRepositoryImpl
import com.example.aisle.auth.domain.repository.IAuthRepository
import com.example.aisle.auth.domain.use_cases.AuthUseCases
import com.example.aisle.auth.domain.use_cases.GetLoginViaPhoneUseCase
import com.example.aisle.auth.domain.use_cases.GetOtpVerifyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton


@Module
@InstallIn(ActivityRetainedComponent::class)
object AuthModule {

    @Provides
    fun provideAuthApi() : IAuthApi =
        AuthApiImpl()

    @Provides
    fun provideAuthRepository(api: IAuthApi) : IAuthRepository =
        AuthRepositoryImpl(api)

    @Provides
    fun provideAuthUseCases(repo: IAuthRepository) : AuthUseCases =
        AuthUseCases(
            ucGetLoginViaPhoneUseCase = GetLoginViaPhoneUseCase(repo),
            ucGetOtpVerifyUseCase = GetOtpVerifyUseCase(repo)
        )
}