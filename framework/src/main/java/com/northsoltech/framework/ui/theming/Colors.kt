package com.northsoltech.framework.ui.theming

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)
val LightGray = Color(0xFFF1F1F1)
val LightBlack = Color(0xFF383838)
val Black = Color(0xFF000000)
val Blue = Color(0xFF30759E)
val DarkBlue = Color(0xFF1B4258)
val Orange = Color(0xFFFF9800)
val LightPink = Color(0xFFFFD9D9)
val DarkPink = Color(0xFFB19696)
val SomeGreenDegree = Color(0xFFD1DABB)

val colors = lightColors(
    primary = Black,
    primaryVariant = DarkBlue,
    secondary = LightBlack,
    background = White,
    surface = LightGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Black,
    onSurface = Black,
)