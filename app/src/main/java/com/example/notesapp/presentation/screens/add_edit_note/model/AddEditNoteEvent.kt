package com.example.notesapp.presentation.screens.add_edit_note.model

sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String) : AddEditNoteEvent()
    data class EnteredContent(val value: String) : AddEditNoteEvent()
    data class ChangeColor(val color: Int) : AddEditNoteEvent()
    data object SaveNote : AddEditNoteEvent()
}