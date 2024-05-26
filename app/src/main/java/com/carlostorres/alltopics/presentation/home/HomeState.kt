package com.carlostorres.alltopics.presentation.home

import com.carlostorres.alltopics.data.remote.model.ProductsItem

data class HomeState(
    val isLoading : Boolean = true,
    val productList : List<ProductsItem> = emptyList()
)
