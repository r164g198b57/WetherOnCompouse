package com.github.r164g198b57.wetheroncompouse2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.r164g198b57.wetheroncompouse2.screens.MainScreen
import com.github.r164g198b57.wetheroncompouse2.ui.theme.WetherOnCompouse2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WetherOnCompouse2Theme {
                MainScreen()
            }
        }
    }
}


