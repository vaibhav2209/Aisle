package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class LikesX(
    @SerialName("can_see_profile")
    val canSeeProfile: Boolean,
    @SerialName("likes_received_count")
    val likesReceivedCount: Int,
    val profiles: List<ProfileX>
)