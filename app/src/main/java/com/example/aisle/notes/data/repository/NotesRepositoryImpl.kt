package com.example.aisle.notes.data.repository

import com.example.aisle.notes.data.remote.INotesApi
import com.example.aisle.notes.domain.model.Notes
import com.example.aisle.notes.domain.repository.INotesRepository
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val notesApi : INotesApi
) : INotesRepository {

    override suspend fun getNotes(token: String): Notes {
        return notesApi.getNotes(token)
    }
}