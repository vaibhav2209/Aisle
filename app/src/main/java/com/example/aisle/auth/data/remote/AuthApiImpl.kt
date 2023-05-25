package com.example.aisle.auth.data.remote

import com.example.aisle.auth.domain.model.OtpVerifyDto
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.domain.model.PhoneLoginDto
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import com.example.aisle.utils.network.ApiEndPoint
import com.example.aisle.utils.network.KtorHttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class AuthApiImpl : IAuthApi {

    override suspend fun getLoginViaPhone(request: PhoneLoginRequest): PhoneLoginDto {
        return KtorHttpClient.ktorClient.post(ApiEndPoint.LOGIN_VIA_PHONE) {
            setBody(request)
        }.body()
    }

    override suspend fun getOtpVerification(request: OtpVerifyRequest): OtpVerifyDto {
        return KtorHttpClient.ktorClient.post(ApiEndPoint.VERIFY_OTP) {
            setBody(request)
        }.body()
    }
}