package com.example.szfirstapplication.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.szfirstapplication.ui.theme.SzFirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            SzFirstApplicationTheme {
                Surface {

                }
            }
        }
    }
}




@Composable
@Preview(showBackground = true)
fun PreviewMainActivity(){

}