package com.example.aisle.notes.domain.repository

import com.example.aisle.notes.domain.model.Notes

interface INotesRepository {

    suspend fun getNotes(token: String): Notes
}