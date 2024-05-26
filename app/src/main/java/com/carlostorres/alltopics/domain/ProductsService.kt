package com.carlostorres.alltopics.domain

import com.carlostorres.alltopics.data.remote.model.ProductsItem
import com.carlostorres.alltopics.utils.Constants.ENDPOINT_PRODUCTS
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ProductsService {

    @GET(ENDPOINT_PRODUCTS)
    suspend fun getAllProducts() : List<ProductsItem>

}