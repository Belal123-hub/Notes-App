package com.example.notesapp.data.note

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
)