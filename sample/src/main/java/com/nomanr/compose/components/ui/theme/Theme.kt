package com.nomanr.compose.components.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class AppColors(
    val primary: Color,
    val background: Color,
    val surface: Color,
    val text: Color,
    val textSecondary: Color,
    val divider: Color,
    val isDark: Boolean
) {
    companion object {
        fun lightColors() = AppColors(
            primary = Color.Black,
            background = Color.White,
            surface = Color.White,
            text = Color.Black,
            textSecondary = Color.DarkGray,
            divider = Color.LightGray,
            isDark = false
        )

        fun darkColors() = AppColors(
            primary = Color.White,
            background = Color.Black,
            surface = Color.Black,
            text = Color.White,
            textSecondary = Color.LightGray,
            divider = Color.DarkGray,
            isDark = true
        )
    }
}

data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    ),
    val h2: TextStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    val subtitle: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    val body: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    val caption: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Light
    )
)

val LocalAppColors = staticCompositionLocalOf { AppColors.lightColors() }
val LocalAppTypography = staticCompositionLocalOf { AppTypography() }

object ThemeState {
    val isDarkMode = mutableStateOf(false)
}

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colors = if (ThemeState.isDarkMode.value) {
        AppColors.darkColors()
    } else {
        AppColors.lightColors()
    }

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides AppTypography()
    ) {
        content()
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
}
