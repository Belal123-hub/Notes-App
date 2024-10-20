package com.example.notesapp.data.repository

import com.example.notesapp.data.note.NoteDao
import com.example.notesapp.data.note.NoteEntity
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes().map { notes ->
            notes.map { db -> db.toDomain() }
        }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.toDomain()
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note.toEntity())
    }

    override suspend fun deleteNote(noteId: Int?) {
        dao.deleteNote(noteId)
    }


    private fun NoteEntity.toDomain() = Note(
        id = id,
        title = title,
        content = content,
        timestamp = timestamp,
        color = color
    )

    private fun Note.toEntity() = NoteEntity(
        id = id,
        title = title,
        content = content,
        timestamp = timestamp,
        color = color
    )
}