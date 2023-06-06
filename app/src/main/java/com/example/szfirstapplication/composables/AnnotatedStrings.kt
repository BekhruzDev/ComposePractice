package com.example.szfirstapplication.composables

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AnnotatedName() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(
                    textAlign = TextAlign.Start,
                    textDirection = TextDirection.ContentOrRtl
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 60.sp
                    )
                ) {
                    append("B")
                }
                withStyle(
                    style = SpanStyle(
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 30.sp
                    )
                ) {
                    append("EKHRUZ")
                }

            }
        },
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    )
}

@Composable
fun AnnotatedSurName() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(
                    textAlign = TextAlign.Start,
                    textDirection = TextDirection.ContentOrRtl
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 60.sp
                    )
                ) {
                    append("A")
                }
                withStyle(
                    style = SpanStyle(
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 30.sp
                    )
                ) {
                    append("BDULLAKHUJAEV")
                }
            }
        },
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    )
}
