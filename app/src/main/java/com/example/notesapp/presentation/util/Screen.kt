package com.example.notesapp.presentation.util

sealed class Screen(val route: String) {
    data object NotesScreen : Screen("notesScreen")
    data object AddEditNoteScreen : Screen("add_edit_note_screen")
}