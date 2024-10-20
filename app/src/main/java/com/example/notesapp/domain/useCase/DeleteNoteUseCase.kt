package com.example.notesapp.domain.useCase

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note.id)
    }
}