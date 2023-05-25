package com.example.aisle.notes.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.example.aisle.auth.domain.model.OtpVerifyDto
import com.example.aisle.auth.domain.model.OtpVerifyRequest
import com.example.aisle.auth.domain.model.PhoneLoginDto
import com.example.aisle.auth.domain.model.PhoneLoginRequest
import com.example.aisle.notes.domain.model.Notes
import com.example.aisle.utils.network.Resource

interface INotesModelContract {

    fun getNotes(token: String)
    fun doObserverNotes(): LiveData<Resource<Notes>>
}