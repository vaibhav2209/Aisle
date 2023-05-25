package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Invites(
    @SerialName("pending_invitations_count")
    val pendingInvitationsCount: Int,
    val profiles: List<Profile>,
    val totalPages: Int
)