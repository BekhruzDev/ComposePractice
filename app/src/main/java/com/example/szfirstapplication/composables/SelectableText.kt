package com.example.szfirstapplication.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@Composable
fun SelectableText() {
    SelectionContainer {
        Column {
            Text(text = "this text is selectable!")
            DisableSelection {
                Text(text = "this text is not selectable!")
            }
            Text(text = "Again, this text is selectable!")
        }
    }
}

