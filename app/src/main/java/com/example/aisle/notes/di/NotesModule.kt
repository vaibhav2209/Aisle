package com.example.aisle.notes.di

import com.example.aisle.notes.data.remote.INotesApi
import com.example.aisle.notes.data.remote.NotesApiImpl
import com.example.aisle.notes.data.repository.NotesRepositoryImpl
import com.example.aisle.notes.domain.repository.INotesRepository
import com.example.aisle.notes.domain.use_cases.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.ktor.client.*


@Module
@InstallIn(ActivityRetainedComponent::class)
object NotesModule {

    @Provides
    fun provideNotesApi() : INotesApi =
        NotesApiImpl()

    @Provides
    fun provideNotesRepository(api: INotesApi) : INotesRepository =
        NotesRepositoryImpl(api)

    @Provides
    fun provideNotesUseCases(repo: INotesRepository) : GetNotesUseCase =
        GetNotesUseCase(repo)
}