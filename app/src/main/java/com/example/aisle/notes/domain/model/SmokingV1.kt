package com.example.aisle.notes.domain.model

@kotlinx.serialization.Serializable
data class SmokingV1(
    val id: Int,
    val name: String,
    val name_alias: String
)