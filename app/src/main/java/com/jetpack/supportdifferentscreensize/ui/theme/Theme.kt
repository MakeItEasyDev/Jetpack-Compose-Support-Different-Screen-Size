package com.jetpack.supportdifferentscreensize.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import com.jetpack.supportdifferentscreensize.*

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

@Composable
fun ProvideDimens(dimensions: Dimensions, content: @Composable () -> Unit) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content )
}

private val LocalAppDimens = staticCompositionLocalOf { smallDimension }

@Composable
fun ProvideAppTypography(typography: Typography, content: @Composable () -> Unit) {
    val typographySet = remember { typography }
    CompositionLocalProvider(LocalAppTypography provides typographySet, content = content )
}

private val LocalAppTypography = staticCompositionLocalOf { textSmallDimension }

@Composable
fun SupportDifferentScreenSizeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette
    val configuration = LocalConfiguration.current
    val dimensions = if (configuration.screenWidthDp <= 420) smallDimension else sw420Dimension
    val typography = if (configuration.screenWidthDp <= 420) textSmallDimension else textSw420Dimensions

    ProvideDimens(dimensions = dimensions) {
        ProvideAppTypography(typography = typography) {
            MaterialTheme(
                colors = colors,
                shapes = Shapes,
                typography = Typography,
                content = content
            )
        }
    }
}

object SupportDifferentScreenSizeTheme {
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current
    val textStyle: Typography
        @Composable
        get() = LocalAppTypography.current
}


























