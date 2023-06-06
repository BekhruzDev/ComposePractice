package com.example.szfirstapplication.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CocaColaCo() {
    Box(modifier = Modifier.padding(16.dp)) {
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.W900,
                    color = Color.Red,
                    fontSize = 50.sp
                )
            ) {
                append("The Coca-Cola")
            }
            withStyle(
                style = SpanStyle(
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W700,
                    baselineShift = BaselineShift.Superscript,
                    color = Color.Red, fontSize = 20.sp
                )
            ) {
                append("  Co.")
            }
        })
    }
}
