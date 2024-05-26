package com.carlostorres.alltopics.data.remote

import com.carlostorres.alltopics.data.remote.model.ProductsItem
import com.carlostorres.alltopics.domain.ProductsService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRemoteDataSource @Inject constructor(
    private val service: ProductsService
) {

    suspend fun getAllProducts() : List<ProductsItem> = service.getAllProducts()

}