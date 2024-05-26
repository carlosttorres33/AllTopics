package com.carlostorres.alltopics.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlostorres.alltopics.data.remote.model.ProductsItem
import com.carlostorres.alltopics.domain.usecase.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        fetchProducts()
    }

    fun fetchProducts(){

        viewModelScope.launch {

            val lista : List<ProductsItem> = getAllProductsUseCase.invoke().flattenToList()
            Log.d("ViewModel", "$lista")
            println()

            if (lista.isNotEmpty()) {
                _state.update {
                    it.copy(
                        productList = lista,
                        isLoading = false
                    )
                }
            } else {
                _state.update {
                    it.copy(
                        productList = emptyList(),
                        isLoading = false
                    )
                }
            }

        }

    }
    suspend fun <T> Flow<List<T>>.flattenToList() =
        flatMapConcat { it.asFlow() }.toList()

    private fun getProducts() {

        viewModelScope.launch {

            _state.update {
                it.copy(isLoading = true)
            }

            getAllProductsUseCase.invoke().collectLatest { result ->

                if (result.isNotEmpty()) {
                    _state.update {
                        it.copy(
                            productList = result,
                            isLoading = false
                        )
                    }
                } else {
                    _state.update {
                        it.copy(
                            productList = emptyList(),
                            isLoading = false
                        )
                    }
                }


            }

        }

    }

}