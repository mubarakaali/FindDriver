package com.northsoltech.framework.ui.theming

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val PRIMARY_COLOR = Color(0xFF3F51B5)
val PRIMARY_VARIANT_COLOR = Color(0xFF594ACB)
val OVERLAY_COLOR = Color(0xB3000000)
val OVERLAY_VARIANT_COLOR = Color(0x66000000)
val PRIMARY_TEXT_COLOR = Color(0xFF302F2F)
val SECONDARY_TEXT_COLOR = Color(0xFF6B5E5E)
val GRADIENT_START_COLOR = Color(0xFF594ACB)
val GRADIENT_END_COLOR = Color(0xFF7669EA)
val TYPOGRAPHIC_GRADIENT_START_COLOR = Color(0xFF8A7EED)
val TYPOGRAPHIC_GRADIENT_END_COLOR = Color(0xFF5E54BB)
val TYPOGRAPHIC_COLOR = Color(0xFF9287FF)
val BACKGROUND_COLOR = Color(0xFFFFFCFC)
val BACKGROUND_VARIANT_COLOR = Color(0xFF868080)
val SURFACE_COLOR = Color(0xFFD6D5D5)
val SURFACE_VARIANT_2_COLOR = Color(0xFF2F2F2F)
val SURFACE_VARIANT_3_COLOR = Color(0xFF4E4E4E)
val ERROR_COLOR = Color(0xFFB3261E)

val ICONS_DEFAULT_GRAY = Color(0xFF686B6F)
val CAPTION_TEXT_COLOR = Color(0xFF707070)

val GRAY_LEVEL_1 = Color(0xFFA0A0A0)
val GRAY_LEVEL_2 = Color(0xFFC6C6C6)
val GRAY_LEVEL_3 = Color(0xFFE1E1E1)
val GRAY_LEVEL_4 = Color(0xFFF0F0F0)
val GRAY_LEVEL_5 = Color(0xFFFFFFFF)
val ENHANCE_PRIMARY_TEXT_COLOR = Color(0xFF404040)

fun Color.Companion.parseHex(hex: String) = Color(android.graphics.Color.parseColor(hex))

val colors = lightColors(
    primary = PRIMARY_COLOR,
    primaryVariant = PRIMARY_VARIANT_COLOR,
    background = BACKGROUND_COLOR,
    surface = SURFACE_COLOR,
    onPrimary = PRIMARY_TEXT_COLOR,
    onSecondary = SECONDARY_TEXT_COLOR,
    onBackground = PRIMARY_TEXT_COLOR,
    onSurface = SECONDARY_TEXT_COLOR,
    onError = ERROR_COLOR
)