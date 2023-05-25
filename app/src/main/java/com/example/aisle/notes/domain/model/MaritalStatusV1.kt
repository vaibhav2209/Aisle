package com.example.aisle.notes.domain.model

@kotlinx.serialization.Serializable
data class MaritalStatusV1(
    val id: Int,
    val name: String,
    val preference_only: Boolean
)