package com.northsoltech.framework.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp


@Composable
fun MainTitleText(title:String){
    Text(
        text = title,
        style = MaterialTheme.typography.h1.copy(fontSize = 48.sp),
        color = MaterialTheme.colors.primary,
        fontFamily = FontFamily.Cursive,
    )
}
@Composable
fun MediumTitleText(title:String){
    Text(
        text = title,
        style = MaterialTheme.typography.h3,
        color = MaterialTheme.colors.primary,
        fontFamily = FontFamily.Serif,
    )
}