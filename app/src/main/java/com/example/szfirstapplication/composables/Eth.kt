package com.example.szfirstapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.szfirstapplication.ui.theme.ethzMain


@Composable
fun Eth() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(ethzMain),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EthLogo()
        EthSlogan()
    }
}


@Composable
fun EthLogo() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "ETH",
            color = Color.White,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.W900,
            fontFamily = FontFamily.SansSerif,
            fontSize = 50.sp,
        )
        Text(
            text = "Zurich",
            color = Color.White,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.W800,
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 16.dp, top = 19.dp),
        )

    }
}

@Composable
fun EthSlogan() {

    Text(
        text = "Where the future begins...",
        fontSize = MaterialTheme.typography.h6.fontSize,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W600,
        fontStyle = FontStyle.Italic,
        color = Color.White,
        modifier = Modifier.padding(top = 16.dp)
    )

}
