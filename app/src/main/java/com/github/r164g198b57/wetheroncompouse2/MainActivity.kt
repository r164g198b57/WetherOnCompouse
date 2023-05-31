package com.github.r164g198b57.wetheroncompouse2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.github.r164g198b57.wetheroncompouse2.screens.MainCard
import com.github.r164g198b57.wetheroncompouse2.screens.TabLayout

import com.github.r164g198b57.wetheroncompouse2.ui.theme.WetherOnCompouse2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WetherOnCompouse2Theme {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "background",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.75f),
                    contentScale = ContentScale.Crop
                )
                Column {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}


