package com.github.r164g198b57.wetheroncompouse2.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.github.r164g198b57.wetheroncompouse2.R
import com.github.r164g198b57.wetheroncompouse2.data.WeatherModel
import com.github.r164g198b57.wetheroncompouse2.ui.theme.BlueLight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset

import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@Composable
fun MainCard() {

    Column(
        modifier = Modifier
            .padding(7.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = BlueLight,
            elevation = 0.dp,
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
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "search",
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
                                painter = painterResource(id = R.drawable.refresh),
                                contentDescription = "search",
                                tint = Color.White
                            )
                        }

                    }
                }


            }
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabLayout() {
    val tablist = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier
        .padding(start = 7.dp, end = 7.dp)
        .clip(
            RoundedCornerShape(5.dp)
        )) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { pos->
                        TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState,pos))
            },
            backgroundColor = BlueLight,
            contentColor = Color.White
        ) {
            tablist.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = { coroutineScope.launch {  pagerState.animateScrollToPage(index)}},
                    text = { Text(text = text) }
                )
            }
        }
        HorizontalPager(count = tablist.size, state = pagerState, modifier = Modifier.weight(1.0f)) { index ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(
                    listOf(
                        WeatherModel(
                            "London",
                            "10:57",
                            "25 C",
                            "Rainy day",
                            "//cdn.weatherapi.com/weather/64x64/day/122.png",
                            "",
                            "",
                            ""
                        ),
                        WeatherModel(
                            "London",
                            "01.06",
                            "",
                            "Sunny",
                            "//cdn.weatherapi.com/weather/64x64/day/176.png",
                            "26 C",
                            "12 C",
                            "jggiptnpnhgkiug"
                        ),
                    )
                ) { index, item ->
                    ListItem(item)
                }


            }

        }
    }
}
