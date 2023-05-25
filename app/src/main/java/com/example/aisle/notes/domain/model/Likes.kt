package com.example.aisle.notes.domain.model

data class Likes(
    val canSeeProfile: Boolean = false,
    val likesReceivedCount: Int = 0,
    val likesUsers: List<LikesUser> = mutableListOf()
)