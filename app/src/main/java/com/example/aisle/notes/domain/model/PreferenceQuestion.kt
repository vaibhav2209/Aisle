package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class PreferenceQuestion(
    @SerialName("first_choice")
    val firstChoice: String,
    @SerialName("second_choice")
    val secondChoice: String
)