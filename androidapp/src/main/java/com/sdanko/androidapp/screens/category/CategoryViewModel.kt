package com.sdanko.androidapp.screens.category

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.sdanko.androidapp.data.MongoSync
import com.sdanko.androidapp.models.Category
import com.sdanko.androidapp.models.Post
import com.sdanko.androidapp.util.RequestState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CategoryViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _categoryPosts: MutableState<RequestState<List<Post>>> =
        mutableStateOf(RequestState.Idle)
    val categoryPosts: State<RequestState<List<Post>>> = _categoryPosts

    init {
        _categoryPosts.value = RequestState.Loading
        val selectedCategory = savedStateHandle.get<String>("category")
        if (selectedCategory != null) {
            viewModelScope.launch {
                MongoSync.searchPostsByCategory(
                    category = Category.valueOf(selectedCategory)
                ).collectLatest { _categoryPosts.value = it }
            }
        }
    }
}

