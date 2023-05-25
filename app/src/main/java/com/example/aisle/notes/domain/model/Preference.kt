package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Preference(
    @SerialName("answer_id")
    val answerId: Int,
    val id: Int,
    @SerialName("preference_question")
    val preferenceQuestion: PreferenceQuestion,
    val value: Int
)