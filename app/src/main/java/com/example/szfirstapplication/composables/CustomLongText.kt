package com.example.szfirstapplication.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun CustomLongText() {
    Text(
        text = "Long teeeeeeeeeeeeeeeeeeeeeeeeeeeeeext!!!!!!!!!!!!".repeat(25),
        maxLines = 4,
        overflow = TextOverflow.Ellipsis
    )
}
