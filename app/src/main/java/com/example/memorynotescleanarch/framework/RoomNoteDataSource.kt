package com.example.memorynotescleanarch.framework

import android.content.Context
import com.example.core.data.Note
import com.example.core.repository.NoteDataSource
import com.example.memorynotescleanarch.framework.db.DatabaseService
import com.example.memorynotescleanarch.framework.db.NoteEntity
import com.example.memorynotescleanarch.framework.db.toNote
import com.example.memorynotescleanarch.framework.db.toNoteEntity

class RoomNoteDataSource (context: Context) : NoteDataSource{

    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(note.toNoteEntity())

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNotesEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(note.toNoteEntity())
}