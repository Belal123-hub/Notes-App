package com.example.notesapp.presentation.screens.notes.model

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.util.NoteOrder
import com.example.notesapp.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
