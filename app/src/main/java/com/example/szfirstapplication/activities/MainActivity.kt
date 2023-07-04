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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.szfirstapplication.composables.PersonLazyColumn
import com.example.szfirstapplication.composables.PersonLazyColumnWithStickyHeader
import com.example.szfirstapplication.repositories.PersonRepository
import com.example.szfirstapplication.ui.theme.SzFirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SzFirstApplicationTheme {
                val repo = PersonRepository()
                val peopleList = repo.getAllPeople()
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
                        PersonLazyColumnWithStickyHeader(list = peopleList)
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
