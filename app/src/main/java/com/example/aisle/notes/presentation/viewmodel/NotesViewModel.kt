package com.example.aisle.notes.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisle.notes.domain.model.Notes
import com.example.aisle.notes.domain.use_cases.GetNotesUseCase
import com.example.aisle.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesUseCase: GetNotesUseCase
) : ViewModel(),
    INotesModelContract {

    /* Get Notes */
    private val notes = MutableLiveData<Resource<Notes>>()

    override fun getNotes(token: String) {
        viewModelScope.launch {
            notes.postValue(Resource.Loading)

            val result = notesUseCase(token)

            notes.postValue(result)
        }
    }

    override fun doObserverNotes(): LiveData<Resource<Notes>> {
        return notes
    }
}