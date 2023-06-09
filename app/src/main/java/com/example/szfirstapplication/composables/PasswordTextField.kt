package com.example.szfirstapplication.composables

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.szfirstapplication.R

@Composable
fun PasswordTextField() {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }
    val iconId =
        if (passwordVisible) R.drawable.ic_visibility_24 else R.drawable.ic_visibility_off_24
    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        label = {
            Text("Password")
        },
        placeholder = {  //hint in xml
            Text(text = "Enter password")
        },
        leadingIcon = {
                      Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock icon")
        },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                val painter = painterResource(id = iconId)
                Icon(painter = painter, contentDescription = "icon visibility")
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )


}


@Composable
@Preview
fun PreviewPasswordTextField() {
    Surface(color = MaterialTheme.colors.background) {
        PasswordTextField()
    }
}