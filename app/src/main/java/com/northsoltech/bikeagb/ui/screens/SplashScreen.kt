package com.northsoltech.bikeagb.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewSplashScreen(){
//    BikeaGbTheme {
        SplashScreen()
//    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Bikea GB")
    }
}