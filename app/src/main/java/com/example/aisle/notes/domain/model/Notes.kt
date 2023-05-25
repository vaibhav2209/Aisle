package com.example.aisle.notes.domain.model

@kotlinx.serialization.Serializable
data class Notes(
    val invites: Invites,
    val likes: LikesX
)