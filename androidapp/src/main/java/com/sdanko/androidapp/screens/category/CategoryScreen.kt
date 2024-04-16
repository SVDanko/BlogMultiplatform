package com.sdanko.androidapp.screens.category

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.sdanko.androidapp.components.PostCardsView
import com.sdanko.androidapp.models.Category
import com.sdanko.androidapp.models.Post
import com.sdanko.androidapp.util.RequestState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    posts: RequestState<List<Post>>,
    category: Category,
    onBackPress: () -> Unit,
    onPostClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = category.name) },
                navigationIcon = {
                    IconButton(onClick = { onBackPress() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Arrow Icon"
                        )
                    }
                }
            )
        }
    ) {
        PostCardsView(
            posts = posts,
            topMargin = it.calculateTopPadding(),
            onPostClick = onPostClick
        )
    }
}