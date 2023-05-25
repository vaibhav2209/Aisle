package com.example.aisle.notes.data.remote

import com.example.aisle.notes.domain.model.Notes
import com.example.aisle.utils.network.ApiEndPoint
import com.example.aisle.utils.network.KtorHttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonElement

class NotesApiImpl : INotesApi {

    override suspend fun getNotes(token: String): Notes {
        return KtorHttpClient.ktorClient.get(ApiEndPoint.PROFILE_LIST) {
            header(HttpHeaders.Authorization, "Bearer $token")
        }.body()
    }
}