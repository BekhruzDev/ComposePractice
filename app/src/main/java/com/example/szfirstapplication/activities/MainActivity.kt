package com.example.szfirstapplication.activities

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.szfirstapplication.composables.LimitCharLength
import com.example.szfirstapplication.composables.PersonLazyColumn
import com.example.szfirstapplication.data.repositories.PersonRepository
import com.example.szfirstapplication.ui.theme.SzFirstApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var name by remember { mutableStateOf("") }
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
                        LimitCharLength(name) { newName -> name = newName }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            Toast.makeText(this@MainActivity, "$name is sent!",Toast.LENGTH_SHORT).show()
                        }) {
                            Text("Send name")
                        }
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
