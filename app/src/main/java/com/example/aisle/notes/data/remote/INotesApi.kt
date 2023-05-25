package com.example.aisle.notes.data.remote

import com.example.aisle.notes.domain.model.Notes
import kotlinx.serialization.json.JsonElement

interface INotesApi {

    suspend fun getNotes(token: String): Notes
}