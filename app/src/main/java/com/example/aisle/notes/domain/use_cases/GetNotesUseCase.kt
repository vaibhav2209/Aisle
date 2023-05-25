package com.example.aisle.notes.domain.use_cases

import com.example.aisle.notes.domain.model.Notes
import com.example.aisle.notes.domain.repository.INotesRepository
import com.example.aisle.utils.network.Resource
import javax.inject.Inject


class GetNotesUseCase @Inject constructor(
    private val repository: INotesRepository
) {

    suspend operator fun invoke(token: String): Resource<Notes> {
        return try {

            val response = repository.getNotes(token)

            Resource.Success(response)

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}