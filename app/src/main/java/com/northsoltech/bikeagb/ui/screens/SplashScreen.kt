package com.northsoltech.bikeagb.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.northsoltech.bikeagb.R
import com.northsoltech.framework.components.MainTitleText
import com.northsoltech.framework.ui.theming.Dimension

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