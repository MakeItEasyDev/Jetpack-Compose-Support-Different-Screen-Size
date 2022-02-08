package com.jetpack.supportdifferentscreensize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import com.jetpack.supportdifferentscreensize.ui.theme.SupportDifferentScreenSizeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupportDifferentScreenSizeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Support Different Screen Size",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        SupportDifferentScreenSize()
                    }
                }
            }
        }
    }
}

@Composable
fun SupportDifferentScreenSize() {
    val configuration = LocalConfiguration.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                if (configuration.screenWidthDp <= 420) Color.Red else Color.Green
            )
            .padding(
                horizontal = SupportDifferentScreenSizeTheme.dimens.dimens_1,
                vertical = SupportDifferentScreenSizeTheme.dimens.dimens_2
            )
    ) {
        Text(
            text = "Welcome to Make it Easy",
            fontSize = SupportDifferentScreenSizeTheme.textStyle.fontSize_1.fontSize,
            color = Color.White
        )
    }
}






















