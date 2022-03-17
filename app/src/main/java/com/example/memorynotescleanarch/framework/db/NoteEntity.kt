package com.example.memorynotescleanarch.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.core.data.Note

@Entity(tableName = "note")
data class NoteEntity(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "content")
    val content: String,

    @ColumnInfo(name = "creation_date")
    val creationTime: Long,

    @ColumnInfo(name = "update_time")
    val updateTime: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
)

fun Note.toNoteEntity() : NoteEntity {
    return NoteEntity(
        this.title,
        this.content,
        this.creationTime,
        this.updateTime,
        this.id
    )
}

fun NoteEntity.toNote( ): Note {
    return Note(
        this.title,
        this.content,
        this.creationTime,
        this.updateTime,
        this.id
    )
}