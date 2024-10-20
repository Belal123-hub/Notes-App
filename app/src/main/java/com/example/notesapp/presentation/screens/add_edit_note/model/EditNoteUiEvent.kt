package com.example.notesapp.presentation.screens.add_edit_note.model

sealed class EditNoteUiEvent {
    data class ShowSnackbar(val message: String) : EditNoteUiEvent()
    data object SaveNote : EditNoteUiEvent()
}