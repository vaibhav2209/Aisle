package com.example.aisle.auth.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PhoneLoginRequest(
    val number: String
)