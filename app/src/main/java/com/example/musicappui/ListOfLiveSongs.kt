package com.example.musicappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.musicappui.ui.theme.bottomMenu

@Composable
fun ListOfLiveSongs(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF7184EC))

    ){
        LazyColumn(
            content = {
                items(200) {
//                Text(text = "Live Songs",
//                    style = MaterialTheme.typography.titleSmall,
//                    fontWeight = FontWeight.Black,
//                    modifier = Modifier.padding(start = 30.dp)
//                )
                    CardsItems()
                }
            }
            // horizontalAlignment = Alignment.CenterHorizontally
        )
        bottomMenu(items = listOf(
            BottomContent("Home",R.drawable.baseline_home_24),
            BottomContent("Play",R.drawable.baseline_play_circle_24),
            BottomContent("Live",R.drawable.baseline_headset_off_24),
            BottomContent("Search",R.drawable.baseline_search_24),
            //BottomContent("Home",R.drawable.baseline_play_circle_24)
        ), modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(4.dp)
            .clip(RoundedCornerShape(17.dp))
        )

    }

}


@Composable
fun CardsItems() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Live Songs",
                style = MaterialTheme.typography.titleSmall,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 15.dp, top = 20.dp, bottom = 20.dp)
            )
        }

    }
}