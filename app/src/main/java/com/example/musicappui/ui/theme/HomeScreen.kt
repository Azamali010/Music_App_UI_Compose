package com.example.musicappui.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.musicappui.BottomContent
import com.example.musicappui.CurrentMeditation
import com.example.musicappui.R

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color(0xFF6377E6))
            .fillMaxSize()
    ){
        Column {
            GreetingSection()
            ChipSection(
                chips = listOf("Sleep Song", "Sad Song", "Old Song", "New Song",
                    "Sleep Song", "Sad Song", "Old Song", "New Song")
            )
            CurrentMeditation(
                Color.Blue,23,"Ali","akaka",navController)

//            FeatureSection(features = listOf(
//                Feature(
//                    title = "Sleep",
//                    R.drawable.baseline_play_circle_24,
//                    Color.LightGray,
//                    Color.Magenta,
//                    Color.DarkGray
//                ),
//                Feature(
//                    title = "Sleep",
//                    R.drawable.baseline_play_circle_24,
//                    Color.LightGray,
//                    Color.Magenta,
//                    Color.DarkGray
//                ),
//                Feature(
//                    title = "Sleep",
//                    R.drawable.baseline_play_circle_24,
//                    Color.LightGray,
//                    Color.Magenta,
//                    Color.DarkGray
//                ),
//                Feature(
//                    title = "Sleep",
//                    R.drawable.baseline_play_circle_24,
//                    Color.LightGray,
//                    Color.Magenta,
//                    Color.DarkGray
//                ),
//                Feature(
//                    title = "Sleep",
//                    R.drawable.baseline_play_circle_24,
//                    Color.LightGray,
//                    Color.Magenta,
//                    Color.DarkGray)
//
//
//
//            ))
            FeatureSection()
            
        }
        bottomMenu(items = listOf(
            BottomContent("Home",R.drawable.baseline_home_24),
            BottomContent("Play",R.drawable.baseline_play_circle_24),
            BottomContent("Live",R.drawable.baseline_headset_off_24),
            BottomContent("Search",R.drawable.baseline_search_24),
            //BottomContent("Home",R.drawable.baseline_play_circle_24)
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun GreetingSection(
    name : String = "Azam Ali"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = "Good Morning, $name",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(text = "We Wish you have a good Day!",
                style = MaterialTheme.typography.titleSmall
            )

        }
        Icon(
            painter = painterResource(id =
            R.drawable.baseline_search_24),
            contentDescription = "Search",
            tint = Color.Blue,
            modifier = Modifier.size(25.dp)
        )

    }

    
}



//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//    //CurrentMeditation()
//
//}

@Composable
fun bottomMenu(
    items : List<BottomContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = Color.Blue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color(0xFF925A06),
    initialSelectedItemIndex : Int = 0
) {
    var selectedItemIndex by remember { mutableIntStateOf(initialSelectedItemIndex) }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(15.dp)

    ) {
        items.forEachIndexed { index, item ->
            BottomBarItems(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index

            }

        }

    }

    
}

@Composable
fun BottomBarItems(
    item : BottomContent,
    isSelected : Boolean = false,
    activeHighlightColor: Color = Color.Blue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color(0xFF925A06),
    onItemClick : () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ){
            Icon(painter = painterResource(id = item.iconId), contentDescription =item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )

        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )

    }


}






@Composable
fun ChipSection(
    chips : List<String>
) {
    var selectedChipsIndex by remember { mutableIntStateOf(0) }
    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier =
                Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipsIndex = it

                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipsIndex == it) Color.Blue
                        else Color(0xFFD3902E)
                    )
                    .padding(15.dp)
            ){
                Text(text = chips[it], color = Color.White)

            }
        }
    }

}


@Composable
fun FeatureSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Features",
            modifier = Modifier.padding(start = 17.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
            //style = MaterialTheme.typography.titleSmall,
//            modifier = Modifier.size(25.dp)
//                .padding(start = 15.dp)
        )
       LazyVerticalGrid(columns = GridCells.Fixed(2),
           contentPadding = PaddingValues(start = 7.dp, end = 7.dp, bottom = 100.dp),
           modifier = Modifier.fillMaxHeight()
       ){
           items(100){
               FeaturesItem()

           }

       }

    }

}

@Composable
fun FeaturesItem(

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF0D5AD))
            .clickable {

            }



    ){
        Column {
            Text(text = "A song is a musical composition performed by the human voice",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black,
                lineHeight = 10.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
            Icon(
                painter =
                painterResource
                    (id = R.drawable.baseline_headset_off_24),
                contentDescription =" Head set off",
                tint = Color.White,
                modifier = Modifier.size(30.dp)


            )

        }

        Text(
            text = "Start",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clickable {
                    ///
                }
                //.background(Color.White)
                .padding(vertical = 6.dp, horizontal = 15.dp)
                .clip(RoundedCornerShape(10.dp)),
            color = Color.Black
        )
        Text(
            text = "Live Now",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,

            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable {
                    ///
                }
                //.background(Color.White)
                .padding(vertical = 6.dp, horizontal = 15.dp)
                .clip(RoundedCornerShape(10.dp)),
            color = Color.Black
        )
    }

}