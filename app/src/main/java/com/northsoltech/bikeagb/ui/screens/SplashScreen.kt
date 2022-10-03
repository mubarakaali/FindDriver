package com.northsoltech.bikeagb.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.northsoltech.bikeagb.R
import com.northsoltech.framework.components.MainTitleText

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
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
       MainTitleText(title = stringResource(id = R.string.app_name))
    }
}