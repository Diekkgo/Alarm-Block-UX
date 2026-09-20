package com.example.alarmblock.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Navy,
    onPrimary = White,
    secondary = Gold,
    onSecondary = Navy,
    tertiary = Gold,
    onTertiary = Navy,
    background = White,
    onBackground = Navy,
    surface = White,
    onSurface = Navy,
    surfaceVariant = DividerGray,
    onSurfaceVariant = Gray,
    error = Alert,
    onError = White,
)

private val DarkColorScheme = darkColorScheme(
    primary = Lavender,
    onPrimary = Navy,
    secondary = Gold,
    onSecondary = Navy,
    tertiary = Gold,
    onTertiary = Navy,
    background = Color(0xFF14172E),
    onBackground = White,
    surface = Color(0xFF1B1F3B),
    onSurface = White,
    error = Alert,
    onError = White,
)

@Composable
fun AlarmBlockTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Dynamic (wallpaper-based) color is intentionally not used here so the
    // app always shows the Alarm Block brand palette, matching the web app.
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
