package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ProfileX(
    val avatar: String,
    @SerialName("first_name")
    val firstName: String
)