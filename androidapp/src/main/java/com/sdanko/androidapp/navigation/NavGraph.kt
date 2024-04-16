package com.sdanko.androidapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sdanko.androidapp.navigation.destinations.categoryRoute
import com.sdanko.androidapp.navigation.destinations.detailsRoute
import com.sdanko.androidapp.navigation.destinations.homeRoute

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        homeRoute(
            onCategorySelect = { category ->
                navController.navigate(Screen.Category.passCategory(category))
            },
            onPostClick = { postId ->
                navController.navigate(Screen.Details.passPostId(postId))
            }
        )
        categoryRoute(
            onBackPress = { navController.popBackStack() },
            onPostClick = { postId ->
                navController.navigate(Screen.Details.passPostId(postId))
            }
        )
        detailsRoute(onBackPress = { navController.popBackStack() })
    }
}