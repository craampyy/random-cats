package com.iglnierod.random_cats.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.iglnierod.random_cats.R

@Composable
fun MyRandomCatContent() {
    var currentImage by remember { mutableStateOf("https://cataas.com/cat") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xFF121212))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(currentImage)
                .crossfade(true)
                .build(),
            modifier = Modifier
                .size(300.dp),
            contentDescription = stringResource(R.string.app_name),
            contentScale = ContentScale.Crop,
        )

        // Botón
        Row(
            modifier = Modifier
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    currentImage += "?"
                    if (currentImage.length > 35)
                        currentImage = "https://cataas.com/cat?"
                },
                modifier = Modifier
                    .padding(16.dp)
            ) {
                // Carga una nueva imagen
                Text("Get Random Cat")
            }
        }
    }
}