package com.example.aisle.auth.domain.repository

import com.example.aisle.auth.domain.model.OtpVerifyDto
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.domain.model.PhoneLoginDto
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import io.ktor.client.statement.*

interface IAuthRepository {

    suspend fun getLoginViaPhone(request: PhoneLoginRequest): PhoneLoginDto

    suspend fun getOtpVerification(request: OtpVerifyRequest): OtpVerifyDto
}