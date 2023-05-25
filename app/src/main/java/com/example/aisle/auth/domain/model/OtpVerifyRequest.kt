package com.example.aisle.auth.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class OtpVerifyRequest(
    val number: String,
    val otp: String
)