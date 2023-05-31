package com.github.r164g198b57.wetheroncompouse2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.github.r164g198b57.wetheroncompouse2.R
import com.github.r164g198b57.wetheroncompouse2.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "background",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.75f),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(7.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = BlueLight),
            elevation = CardDefaults.cardElevation(2.dp),
            shape = RoundedCornerShape(7.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "1 may 1947",
                            style = TextStyle(fontSize = 15.sp),
                            color = Color.White
                        )
                        AsyncImage(
                            model = "https://cdn.weatherapi.com/weather/64x64/day/113.png",
                            contentDescription = "wether image",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(8.dp)
                        )

                    }
                    Text(
                        text = "Berezovka",
                        style = TextStyle(fontSize = 36.sp),
                        color = Color.White
                    )
                    Text(
                        text = "+2 С°",
                        style = TextStyle(fontSize = 73.sp),
                        color = Color.White
                    )
                    Text(
                        text = "Overcast, intermittent rain",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ })
                        {
                            Icon(
                                painter = painterResource(id =  R.drawable.search),
                                contentDescription ="search",
                                tint = Color.White
                                )
                        }
                        Text(
                            text = "+2 С°/+3 С°",
                            style = TextStyle(fontSize = 15.sp),
                            color = Color.White
                        )
                        IconButton(
                                onClick = { /*TODO*/ })
                        {
                            Icon(
                                painter = painterResource(id =  R.drawable.refresh),
                                contentDescription ="search",
                                tint = Color.White
                            )
                        }

                    }
                }


            }
        }

    }
}