package com.example.aisle.auth.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PhoneLoginDto(
    val status: Boolean
)