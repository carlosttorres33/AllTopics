package com.carlostorres.alltopics.domain

import com.carlostorres.alltopics.data.remote.ProductsRemoteDataSource
import com.carlostorres.alltopics.data.remote.model.ProductsItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepositoryImplementation @Inject constructor(
    private val remoteDataSource: ProductsRemoteDataSource
) : ProductsRepository {

    override fun getAllProducts(): Flow<List<ProductsItem>> {
        return flow { remoteDataSource.getAllProducts() }
    }

}