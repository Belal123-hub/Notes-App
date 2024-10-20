package com.example.notesapp.presentation.screens.add_edit_note.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction

@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    imeAction: ImeAction,
    enabled: Boolean = true
) {
    Box(modifier = modifier) {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(imeAction = imeAction),
            enabled = enabled,
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(text = hint, style = textStyle, color = Color.DarkGray)
                }
                innerTextField()
            }
        )
    }
}