package com.example.aisle.notes.domain.model

@kotlinx.serialization.Serializable
data class DrinkingV1(
    val id: Int,
    val name: String,
    val name_alias: String
)