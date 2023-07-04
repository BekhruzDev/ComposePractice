package com.example.szfirstapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.szfirstapplication.models.Person
import com.example.szfirstapplication.ui.theme.Shapes
import com.example.szfirstapplication.ui.theme.SzFirstApplicationTheme
import com.example.szfirstapplication.ui.theme.ethzMain

@Composable
fun PersonItem(person: Person) {
    Row(
        modifier = Modifier
            .background(ethzMain, shape = Shapes.medium)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = person.age.toString(),
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.SansSerif,
            color = MaterialTheme.colors.onBackground,
            fontSize = 24.sp
        )
        Text(
            text = "${person.name} ${person.surname}",
            modifier = Modifier.weight(7f),
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily.SansSerif,
            color = MaterialTheme.colors.onBackground,
            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp,
            maxLines = 1
        )

    }
}

@Composable
@Preview
fun Preview() {
    SzFirstApplicationTheme {
        PersonItem(person = Person(12, "George", "Washington", 56))
    }
}

