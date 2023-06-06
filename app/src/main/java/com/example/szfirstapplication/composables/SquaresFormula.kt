package com.example.szfirstapplication.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.szfirstapplication.ui.theme.ethzMain


@Composable
fun SquaresFormula() {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = ethzMain, shape = MaterialTheme.shapes.small)
            .width(200.dp)
            .height(60.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append("x")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("2")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append(" = ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append("y")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("2")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append(" + ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append("z")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("2")
                }
            }
        )
    }
}
