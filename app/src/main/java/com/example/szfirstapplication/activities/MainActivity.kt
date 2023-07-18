package com.example.szfirstapplication.activities

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.szfirstapplication.R
import com.example.szfirstapplication.composables.PersonLazyColumn
import com.example.szfirstapplication.composables.SpeedometerLikeProgress
import com.example.szfirstapplication.data.repositories.PersonRepository
import com.example.szfirstapplication.ui.theme.SzFirstApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_fast_move))
                    var isLottiePlaying by remember { mutableStateOf(false) }

                    LottieAnimation(composition = composition, modifier = Modifier.fillMaxSize(), isPlaying = isLottiePlaying, iterations = 7, speed = 1.5f)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(24.dp)
                    ) {
                        var speed by remember { mutableStateOf("") }
                        val speedInteger = if(speed.isNotEmpty()) speed.toInt() else 0
                        isLottiePlaying = speedInteger >70
                        SpeedometerLikeProgress(indicatorValue = speedInteger, bigTextFontSize = 35.sp)
                        Spacer(modifier = Modifier.height(24.dp))
                        TextField(
                            value = speed, onValueChange = {
                                    speed = it
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done,
                            ),
                            placeholder = {
                                Text(text = "Need For Speed...")
                            }
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun Preview() {
    SzFirstApplicationTheme {
        val repo = PersonRepository()
        val peopleList = repo.getAllPeople()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PersonLazyColumn(list = peopleList)
        }
    }
}
