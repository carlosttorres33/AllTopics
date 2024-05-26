package com.carlostorres.alltopics.domain

import com.carlostorres.alltopics.data.remote.model.ProductsItem
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getAllProducts() : Flow<List<ProductsItem>>

}