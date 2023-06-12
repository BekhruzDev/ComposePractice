package com.example.szfirstapplication.activities

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.szfirstapplication.composables.GradientButton
import com.example.szfirstapplication.ui.theme.SzFirstApplicationTheme
import com.example.szfirstapplication.ui.theme.ethzMain
import com.example.szfirstapplication.ui.theme.indigo500
import com.example.szfirstapplication.ui.theme.red100

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SzFirstApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(24.dp)
                    ) {
                        GradientButton(
                            "Smile :)", Color.Green, Brush.horizontalGradient(
                                colors = listOf(indigo500, ethzMain)
                            )
                        ) {

                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = false,uiMode = Configuration.UI_MODE_NIGHT_NO)
fun Preview() {
    SzFirstApplicationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GradientButton(
                "Smile :)", Color.Yellow, Brush.horizontalGradient(
                    colors = listOf(indigo500, red100)
                )
            ) {

            }
        }
    }
}
