package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Photo(
    val photo: String,
    @SerialName("photo_id")
    val photoId: Int,
    val selected: Boolean,
    val status: String?
)