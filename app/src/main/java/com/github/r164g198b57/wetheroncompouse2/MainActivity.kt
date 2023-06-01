package com.github.r164g198b57.wetheroncompouse2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.r164g198b57.wetheroncompouse2.screens.MainCard
import com.github.r164g198b57.wetheroncompouse2.screens.TabLayout

import com.github.r164g198b57.wetheroncompouse2.ui.theme.WetherOnCompouse2Theme

const val API_KEY = "a1ab4b133b1c42df9d2112832233105"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WetherOnCompouse2Theme {
                getData("Minsk", this)
                Image(
                    painter = painterResource(
                        id = R.drawable.background
                    ),
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

private fun getData(city: String, context: Context) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY" +
            "&q=$city" +
            "&days=" +
            "3" +
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            Log.d("Ⓒ", "Response: $response")
        },
        {
            Log.d("Ⓒ", "VolleyError: $it")
        }
    )
    queue.add(sRequest)
}