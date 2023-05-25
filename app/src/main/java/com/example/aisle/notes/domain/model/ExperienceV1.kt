package com.example.aisle.notes.domain.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ExperienceV1(
    val id: Int,
    val name: String,
    @SerialName("name_alias")
    val nameAlias: String
)