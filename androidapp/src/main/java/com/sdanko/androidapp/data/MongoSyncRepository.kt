package com.sdanko.androidapp.data

import com.sdanko.androidapp.models.Category
import com.sdanko.androidapp.models.Post
import com.sdanko.androidapp.util.RequestState
import kotlinx.coroutines.flow.Flow

interface MongoSyncRepository {
    fun configureTheRealm()
    fun readAllPosts(): Flow<RequestState<List<Post>>>
    fun searchPostsByTitle(query: String): Flow<RequestState<List<Post>>>
    fun searchPostsByCategory(category: Category): Flow<RequestState<List<Post>>>
}