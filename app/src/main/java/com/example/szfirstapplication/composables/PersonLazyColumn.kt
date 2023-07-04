package com.example.szfirstapplication.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.szfirstapplication.models.Person

@Composable
fun PersonLazyColumn(list: List<Person>) {
    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(
            list,
            key = { id, person -> //key -> unique identifier of the item in the list, useful if we want to save the position of the list when we are back from another screen
                person.id         //In this case we will have to pass e.g. the ID of the object that we have got from the remote service
            }) { index, person ->
            PersonItem(person = person)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PersonLazyColumnWithStickyHeader(list: List<Person>) {
    val sections = listOf("A", "B", "C", "D", "E")
    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        sections.forEach { section ->
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.Cyan), text = "Section $section"
                )
            }
            items(10) { item ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.White), text = "Item $item from section $section"
                )
            }

        }
    }
}