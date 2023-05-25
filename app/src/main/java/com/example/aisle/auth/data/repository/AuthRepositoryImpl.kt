package com.example.aisle.auth.data.repository

import com.example.aisle.auth.data.remote.IAuthApi
import com.example.aisle.auth.domain.model.OtpVerifyDto
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.domain.model.PhoneLoginDto
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import com.example.aisle.auth.domain.repository.IAuthRepository
import io.ktor.client.statement.*
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi : IAuthApi
) : IAuthRepository {

    override suspend fun getLoginViaPhone(request: PhoneLoginRequest): PhoneLoginDto {
        return authApi.getLoginViaPhone(request)
    }

    override suspend fun getOtpVerification(request: OtpVerifyRequest): OtpVerifyDto {
        return authApi.getOtpVerification(request)
    }
}