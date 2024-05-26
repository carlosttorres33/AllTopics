package com.carlostorres.alltopics.domain.usecase

import com.carlostorres.alltopics.data.remote.ProductsRemoteDataSource
import com.carlostorres.alltopics.data.remote.model.ProductsItem
import com.carlostorres.alltopics.domain.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: ProductsRepository
) {

    operator fun invoke() : Flow<List<ProductsItem>> {
        return repository.getAllProducts()
    }

}