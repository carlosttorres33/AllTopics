package com.carlostorres.alltopics.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.carlostorres.alltopics.presentation.home.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsState().value

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        if (state.isLoading) {
            CircularProgressIndicator()
        }else{

            if (state.productList.isNotEmpty()){

                LazyColumn {
                    items(state.productList){

                        Text(it.title, color = Color.White)

                    }
                }

            } else{
                Text("No dATOS", color = Color.White)
            }

        }


    }

}