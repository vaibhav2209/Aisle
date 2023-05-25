package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class IndustryV1(
    val id: Int,
    val name: String,
    @SerialName("preference_only")
    val preferenceOnly: Boolean
)