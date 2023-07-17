package com.example.szfirstapplication.composables

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*


@Composable
fun LimitCharLength(name:String, onNameChanged:(String) ->Unit) {
    val MAX_LENGTH = 10
    var isError by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = name, onValueChange = { newString ->
            val isValid = newString.length <= MAX_LENGTH
            isError = !isValid
            if (isValid) {
               onNameChanged(newString)
            }
        },
        label = { Text(text = "Name") },
        placeholder = { Text(text = "Enter your name") },
        maxLines = 1,
        isError = isError
    )
}
