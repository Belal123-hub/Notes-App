package com.example.notesapp.domain.model

import com.example.notesapp.presentation.ui.theme.BabyBlue
import com.example.notesapp.presentation.ui.theme.LightGreen
import com.example.notesapp.presentation.ui.theme.RedOrange
import com.example.notesapp.presentation.ui.theme.RedPink
import com.example.notesapp.presentation.ui.theme.Violet

data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String) : Exception(message)