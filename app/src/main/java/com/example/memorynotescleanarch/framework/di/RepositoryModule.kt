package com.example.memorynotescleanarch.framework.di

import android.content.Context
import com.example.core.repository.NoteDataSource
import com.example.core.repository.NoteRepository
import com.example.core.usecase.AddNote
import com.example.core.usecase.GetAllNotes
import com.example.core.usecase.GetNote
import com.example.core.usecase.RemoveNote
import com.example.memorynotescleanarch.framework.RoomNoteDataSource
import com.example.memorynotescleanarch.framework.UseCases
import com.example.memorynotescleanarch.framework.db.DatabaseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNoteRepository (@ApplicationContext context: Context) = NoteRepository(
        RoomNoteDataSource(context)
    )

    @Singleton
    @Provides
    fun provideUseCases(noteRepository: NoteRepository) = UseCases(
        AddNote(noteRepository),
        GetAllNotes(noteRepository),
        GetNote(noteRepository),
        RemoveNote(noteRepository)
    )
}