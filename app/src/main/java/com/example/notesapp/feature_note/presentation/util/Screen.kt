package com.example.notesapp.feature_note.presentation.util

sealed class Screen(val route: String){
    object NotesScreen: Screen("notesScreen")
    object AddEditNoteScreen: Screen("add_edit_note_screen")
}