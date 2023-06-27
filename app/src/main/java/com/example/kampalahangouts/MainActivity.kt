package com.example.kampalahangouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.kampalahangouts.ui.KampalaHangoutApp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSize = calculateWindowSizeClass(this)

            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KampalaHangoutApp(
                        windowSize = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KampalaHangoutPreviewDark() {
    AppTheme(darkTheme = true) {
        KampalaHangoutApp(windowSize = WindowWidthSizeClass.Compact)
    }
}

@Preview(showBackground = true)
@Composable
fun KampalaHangoutPreviewLight() {
    AppTheme(darkTheme = false) {
        KampalaHangoutApp(windowSize = WindowWidthSizeClass.Compact)
    }
}

@Preview(showBackground = true, widthDp = 600)
@Composable
fun KampalaHangoutPreviewMedium() {
    AppTheme(darkTheme = true) {
        KampalaHangoutApp(windowSize = WindowWidthSizeClass.Medium)
    }
}

@Preview(showBackground = true, widthDp = 840)
@Composable
fun KampalaHangoutPreviewExpanded() {
    AppTheme(darkTheme = true) {
        KampalaHangoutApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}