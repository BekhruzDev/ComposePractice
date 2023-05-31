package com.example.szfirstapplication.activities

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.szfirstapplication.R
import com.example.szfirstapplication.ui.theme.SzFirstApplicationTheme
import com.example.szfirstapplication.ui.theme.ethzMain

class TextCustomizationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SzFirstApplicationTheme {
                Surface {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Eth()
                        AnnotatedName()
                        AnnotatedSurName()
                        CustomLongText()
                        SelectableText()
                        SquaresFormula()
                        CocaColaCo()
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, name = "TextCustomization", uiMode = UI_MODE_NIGHT_YES)
fun Preview() {
    SzFirstApplicationTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Eth()
            AnnotatedName()
            AnnotatedSurName()
            CustomLongText()
            SelectableText()
            SquaresFormula()
            CocaColaCo()
        }
    }
}

@Composable
private fun CustomText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .width(200.dp)
            .padding(16.dp),
        color = Color.White,
        fontSize = MaterialTheme.typography.h6.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun AnnotatedName() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(
                    textAlign = TextAlign.Start,
                    textDirection = TextDirection.ContentOrRtl
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 60.sp
                    )
                ) {
                    append("B")
                }
                withStyle(
                    style = SpanStyle(
                        color =  if(isSystemInDarkTheme()) Color.White else Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 30.sp
                    )
                ) {
                    append("EKHRUZ")
                }

            }
        },
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    )
}

@Composable
fun AnnotatedSurName() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(
                    textAlign = TextAlign.Start,
                    textDirection = TextDirection.ContentOrRtl
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 60.sp
                    )
                ) {
                    append("A")
                }
                withStyle(
                    style = SpanStyle(
                        color =  if(isSystemInDarkTheme()) Color.White else Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 30.sp
                    )
                ) {
                    append("BDULLAKHUJAEV")
                }
            }
        },
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    )
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
fun CustomLongText() {
    Text(
        text = "Long teeeeeeeeeeeeeeeeeeeeeeeeeeeeeext!!!!!!!!!!!!".repeat(25),
        maxLines = 4,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Column {
            Text(text = "this text is selectable!")
            DisableSelection {
                Text(text = "this text is not selectable!")
            }
            Text(text = "Again, this text is selectable!")
        }
    }
}

@Composable
fun SquaresFormula() {
    Box(modifier = Modifier
        .border(width = 1.dp, color = ethzMain, shape = MaterialTheme.shapes.small,)
        .width(200.dp)
        .height(60.dp), contentAlignment = Alignment.Center)  {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append("x")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("2")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append(" = ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append("y")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("2")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append(" + ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                ) {
                    append("z")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("2")
                }
            }
        )
    }
}

@Composable
fun CocaColaCo(){
    Box(modifier = Modifier.padding(16.dp)){
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.W900,
                    color = Color.Red,
                    fontSize = 50.sp
                )
            ){
                append("The Coca-Cola")
            }
            withStyle(
                style = SpanStyle(
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W700,
                    baselineShift = BaselineShift.Superscript,
                    color = Color.Red, fontSize = 20.sp
                )
            ){
                append("  Co.")
            }
        })
    }
}