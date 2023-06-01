package com.github.r164g198b57.wetheroncompouse2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.r164g198b57.wetheroncompouse2.data.WeatherModel
import com.github.r164g198b57.wetheroncompouse2.screens.MainCard
import com.github.r164g198b57.wetheroncompouse2.screens.TabLayout

import com.github.r164g198b57.wetheroncompouse2.ui.theme.WetherOnCompouse2Theme
import org.json.JSONObject

const val API_KEY = "a1ab4b133b1c42df9d2112832233105"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WetherOnCompouse2Theme {
                val daysList = remember {
                    mutableStateOf(listOf<WeatherModel>())
                }
                getData("Minsk", this, daysList)
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
                    TabLayout(daysList)
                }

            }
        }
    }
}

private fun getData(city: String, context: Context, daysList: MutableState<List<WeatherModel>>) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY" +
            "&q=$city" +
            "&days=" +
            "5" +
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val list = getWetherByDays(response)
            daysList.value = list
            Log.d("Ⓒ", "Response: $response")
        },
        {
            Log.d("Ⓒ", "VolleyError: $it")
        }
    )
    queue.add(sRequest)
}

private fun getWetherByDays(response: String): List<WeatherModel> {
    if (response.isEmpty()) return listOf()
    val list = ArrayList<WeatherModel>()
    val mainObject = JSONObject(response)
    val city = mainObject.getJSONObject("location").getString("name")
    val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")
    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            WeatherModel(
                city,
                item.optString("date"),
                "",
                item.getJSONObject("day").getJSONObject("condition").optString("text"),
                item.getJSONObject("day").getJSONObject("condition").optString("icon"),
                item.getJSONObject("day").optString("maxtemp_c"),
                item.getJSONObject("day").optString("mintemp_c"),
                item.getJSONArray("hour").toString()
            )
        )
    }
    list[0] = list[0].copy(
        time = mainObject.getJSONObject("current").optString("last_updated"),
        currentTemp = mainObject.getJSONObject("current").getString("temp_c")
    )
    return list
}