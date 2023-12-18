package com.example.musicappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CurrentMeditation(
    color: Color = Color(0xFF18D6EE),
    id: Int?,
    body: String?,
    title: String?,
    navController: NavHostController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
            .clickable {
                //navController.navigate(route = "CurrentMeditation/${id}/${title}/${body}")
                navController.navigate(route = "ListOfLiveSongs")

            }

    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Sleep Song: Click Here",
                //color = Color.Black,
                style = MaterialTheme.typography.headlineMedium,
                //modifier = Modifier.size(26.dp)

            )
            Text(text ="This Song Is Best In List, CurrentMeditation",
                //color = Color.Black,
                style = MaterialTheme.typography.titleSmall,
                // modifier = Modifier.size(15.dp)

            )

        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(40.dp)
                .background(Color.White)
                .padding(10.dp)

        )
        {
            Icon(painter = painterResource(
                id = R.drawable.baseline_play_circle_24),
                contentDescription ="Play",
                tint = Color.Blue,
                modifier = Modifier.size(50.dp)
            )

        }

    }

}
