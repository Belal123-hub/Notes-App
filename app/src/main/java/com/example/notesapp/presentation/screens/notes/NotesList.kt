package com.example.notesapp.presentation.screens.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.SnackbarResult
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesapp.domain.model.Note
import com.example.notesapp.presentation.screens.notes.components.NoteItem
import kotlinx.coroutines.launch

@Composable
fun NotesList(
    notes: List<Note>,
    onNoteClick: (Note) -> Unit,
    onDeleteClick: (Note) -> Unit,
    scaffoldState: ScaffoldState
) {
    val scope = rememberCoroutineScope()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(notes) { note ->
            NoteItem(
                note = note,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNoteClick(note) },
                onDeleteClick = {
                    onDeleteClick(note)
                    scope.launch {
                        val result = scaffoldState.snackbarHostState.showSnackbar(
                            message = "Note deleted",
                            actionLabel = "Undo"
                        )
                        if (result == SnackbarResult.ActionPerformed) {
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}