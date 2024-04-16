package com.sdanko.androidapp.models

import com.sdanko.blogmultiplatform.CategoryCommon

enum class Category(override val color: String): CategoryCommon {
    Programming(color = ""),
    Technology(color = ""),
    Design(color = "")
}