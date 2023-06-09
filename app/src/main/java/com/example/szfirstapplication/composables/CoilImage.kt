package com.example.szfirstapplication.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.szfirstapplication.R

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val painter =
            rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(
                    data = "https://images.unsplash.com/photo-1603480922683-02a0b824809a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=368&q=80"
                ).apply {
                    placeholder(R.drawable.ic_image_placeholder_94) //shown during Loading State
                    crossfade(1500)
                    error(R.drawable.ic_google_logo) //shown during Error State
                    transformations(CircleCropTransformation(),)
                }.build()
            )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "RainForest Image", modifier = Modifier.width(720.dp).height(1080.dp))
        /*if(painterState is AsyncImagePainter.State.Loading){
            CircularProgressIndicator()
        }
*/

    }
}