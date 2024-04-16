package com.sdanko.androidapp.navigation

import com.sdanko.androidapp.models.Category as PostCategory
import com.sdanko.androidapp.util.Constants.CATEGORY_ARGUMENT
import com.sdanko.androidapp.util.Constants.POST_ID_ARGUMENT

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
    data object Category : Screen(route = "category_screen/{${CATEGORY_ARGUMENT}}") {
        fun passCategory(category: PostCategory) = "category_screen/${category.name}"
    }

    data object Details : Screen(route = "details_screen/{${POST_ID_ARGUMENT}}") {
        fun passPostId(id: String) = "details_screen/${id}"
    }
}