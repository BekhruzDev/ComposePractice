package com.example.szfirstapplication.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun CustomTextField() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by rememberSaveable {
            mutableStateOf("HI There!")
        }
        BasicTextField(
            modifier = Modifier.background(Color.LightGray).padding(16.dp),
            value = text, onValueChange = { newText ->
                text = newText
            },

            /*
            Following properties are not included in BasicTextField //Almost no design
            label = {
                 Text(text = "Title")
             },
             leadingIcon = {
                 IconButton(onClick = {
                     Log.d("LeadingIcon", "Clicked")
                 }) {
                     Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
                 }
             },
             trailingIcon = {
                 IconButton(onClick = {
                     Log.d("TrailingIcon", "Clicked")
                 }) {
                     Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Email Icon")
                 }
             },*/
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Send,
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    Log.d("onSend", "Email is sent just now!")
                })

        )
    }
}
