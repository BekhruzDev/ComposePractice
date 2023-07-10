package com.example.szfirstapplication.activities

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.szfirstapplication.data.entities.University
import com.example.szfirstapplication.ui.theme.SzFirstApplicationTheme
import com.example.szfirstapplication.ui.theme.ethzMain
import com.example.szfirstapplication.viewmodels.UniversityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomDataBase : ComponentActivity() {
    private val viewModel: UniversityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SzFirstApplicationTheme {
                val focusManager = LocalFocusManager.current
                val universitiesList by viewModel.universitiesList.collectAsState()
                var universityName by rememberSaveable { mutableStateOf("") }
                var universityRanking by rememberSaveable { mutableStateOf("") }
                Surface {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(ethzMain)
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = universityName,
                            onValueChange = {
                                universityName = it
                            },
                            label = {
                                Text(text = "University name")
                            },
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(
                            value = universityRanking,
                            onValueChange = {
                                universityRanking = it
                            },
                            label = {
                                Text(text = "University ranking")
                            }
                        )

                        Button(onClick = {
                            val university = University(
                                id = 0,
                                name = universityName,
                                ranking = universityRanking.toInt()
                            )
                            addToDatabase(university)
                            focusManager.clearFocus(true)
                            universityName = ""
                            universityRanking = ""

                        }) {
                            Text(text = "Add")
                        }
                        if (universitiesList.isNotEmpty()) {
                            universitiesList.forEach {
                                Text(
                                    text = it.name,
                                    fontSize = MaterialTheme.typography.h6.fontSize,
                                )
                            }
                        } else {
                            Text(
                                text = "No universities",
                                fontSize = MaterialTheme.typography.h6.fontSize,
                            )
                        }
                    }
                }
            }
        }
    }

    private fun addToDatabase(university: University) {
        viewModel.addUniversity(university)
    }
}


@Composable
@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun PreviewRoomDb() {
    SzFirstApplicationTheme {

    }
}
