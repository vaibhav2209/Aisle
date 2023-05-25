package com.example.aisle.auth.data.remote

import com.example.aisle.auth.domain.model.OtpVerifyDto
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.domain.model.PhoneLoginDto
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import io.ktor.client.statement.*

interface IAuthApi {

    suspend fun getLoginViaPhone(request: PhoneLoginRequest): PhoneLoginDto

    suspend fun getOtpVerification(request: OtpVerifyRequest): OtpVerifyDto
}