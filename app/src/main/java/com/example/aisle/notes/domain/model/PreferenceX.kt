package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class PreferenceX(
    val answer: String,
    @SerialName("answer_id")
    val answerId: Int?,
    @SerialName("first_choice")
    val firstChoice: String,
    @SerialName("second_choice")
    val secondChoice: String
)