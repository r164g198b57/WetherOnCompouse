package com.github.r164g198b57.wetheroncompouse2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.github.r164g198b57.wetheroncompouse2.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun ListItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp),
        backgroundColor = BlueLight,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = 6.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    )
            ) {
                Text(
                    text = "17:30",
                    color = Color.White
                )
                Text(
                    text = "Sunny",
                    color = Color.White
                )
            }
            Text(
                text = "+ 12 С°",
                color = Color.White,
                style = TextStyle(fontSize = 24.sp)
            )
            AsyncImage(
                model = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
                contentDescription = "wether image evening",
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 8.dp)
            )

        }

    }
}