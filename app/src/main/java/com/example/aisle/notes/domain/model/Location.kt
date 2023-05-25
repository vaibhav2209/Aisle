package com.example.aisle.notes.domain.model

@kotlinx.serialization.Serializable
data class Location(
    val full: String,
    val summary: String
)