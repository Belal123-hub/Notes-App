package com.example.notesapp.domain.useCase

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}