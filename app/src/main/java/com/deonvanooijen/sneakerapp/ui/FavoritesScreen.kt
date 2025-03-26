package com.deonvanooijen.sneakerapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.deonvanooijen.sneakerapp.viewmodel.FavoritesViewModel
import com.deonvanooijen.sneakerapp.ui.components.BottomNavigationBar
import com.deonvanooijen.sneakerapp.ui.components.FavoritesCard
import com.deonvanooijen.sneakerapp.ui.components.TopSection

@Composable
fun FavoritesScreen(
    navController: NavController,
    favoritesViewModel: FavoritesViewModel = viewModel()
) {
    val favorites by favoritesViewModel.favoriteItems.collectAsState(initial = emptyList())

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopSection(title = "My Favorites") },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (favorites.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Your favorites are empty",
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(favorites) { sneaker ->
                        FavoritesCard(
                            sneaker = sneaker,
                            onRemoveFromFavorites = { favoritesViewModel.removeFromFavorites(sneaker) }
                        )
                    }
                }
            }
        }
    }
}