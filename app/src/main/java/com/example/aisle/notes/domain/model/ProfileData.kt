package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ProfileData(
    @SerialName("invitation_type")
    val invitationType: String,
    val preferences: List<PreferenceX>,
    val question: String
)