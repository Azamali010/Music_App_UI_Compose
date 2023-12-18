package com.example.musicappui

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.musicappui.ui.theme.HomeScreen

@Composable
fun NavigationScreen(navController: NavHostController) {
    NavHost(navController = navController, startDestination ="HomeScreen"){
        composable("HomeScreen"){
            HomeScreen(navController)
        }
        composable("CurrentMeditation/{id}/{title}/{body}",
            arguments = listOf(
                navArgument(name = "id"){
                    type = NavType.IntType
                },
                navArgument(name = "title"){
                    type = NavType.StringType
                },
                navArgument(name = "body"){
                    type = NavType.StringType
                }
            )
            ){
            CurrentMeditation(
                navController = navController,
                id =it.arguments?.getInt("id"),
                title = it.arguments?.getString("title"),
                body = it.arguments?.getString("body")
            )



        }
        composable("ListOfLiveSongs"){
            ListOfLiveSongs(navController)
        }

    }

}