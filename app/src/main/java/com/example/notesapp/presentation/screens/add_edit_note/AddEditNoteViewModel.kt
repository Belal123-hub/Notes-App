package com.example.notesapp.presentation.screens.add_edit_note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.model.InvalidNoteException
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.useCase.NoteUseCases
import com.example.notesapp.presentation.screens.add_edit_note.model.AddEditNoteEvent
import com.example.notesapp.presentation.screens.add_edit_note.model.EditNoteUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var noteTitle by mutableStateOf("")
        private set

    var noteContent by mutableStateOf("")
        private set

    var noteColor by mutableIntStateOf(Note.noteColors.random().toArgb())
        private set

    private val _eventFlow = MutableSharedFlow<EditNoteUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if (noteId != -1) {
                viewModelScope.launch {
                    noteUseCases.getNoteUseCase(noteId)?.also { note ->
                        currentNoteId = note.id
                        noteTitle = note.title
                        noteContent = note.content
                        noteColor = note.color
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.EnteredTitle -> {
                noteTitle = event.value
            }

            is AddEditNoteEvent.EnteredContent -> {
                noteContent = event.value
            }

            is AddEditNoteEvent.ChangeColor -> {
                noteColor = event.color
            }

            is AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNoteUseCase(
                            Note(
                                title = noteTitle,
                                content = noteContent,
                                timestamp = System.currentTimeMillis(),
                                color = noteColor,
                                id = currentNoteId
                            )
                        )
                        _eventFlow.emit(EditNoteUiEvent.SaveNote)
                    } catch (e: InvalidNoteException) {
                        _eventFlow.emit(
                            EditNoteUiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save the note!"
                            )
                        )
                    }
                }
            }
        }
    }
}