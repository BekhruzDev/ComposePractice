package com.example.szfirstapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.szfirstapplication.ui.theme.ethzMain
import com.example.szfirstapplication.ui.theme.indigo500

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),  // adds rounded corners as well

    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(vertical = 8.dp, horizontal = 16.dp).height(60.dp).width(300.dp)
            ,
            contentAlignment = Alignment.Center,

            ) {
            Text(
                text = text,
                color = textColor,
                fontSize = 24.sp
            )
        }
    }

}


@Preview
@Composable
fun PreviewGradientButton() {
    GradientButton(
        "Smile :)", Color.Green, Brush.horizontalGradient(
            colors = listOf(indigo500, ethzMain)
        )
    ) {

    }
}
