package com.deonvanooijen.sneakerapp.ui

import android.widget.Toast
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.deonvanooijen.sneakerapp.viewmodel.CartViewModel
import com.deonvanooijen.sneakerapp.viewmodel.FavoritesViewModel
import com.deonvanooijen.sneakerapp.R
import com.deonvanooijen.sneakerapp.SneakerCard
import com.deonvanooijen.sneakerapp.ui.components.BottomNavigationBar
import com.deonvanooijen.sneakerapp.data.Sneaker

@Composable
fun HomeScreen(
    availableSneakers: List<Sneaker>,
    onAddToCart: (Sneaker) -> Unit,
    onAddToWishlist: (Sneaker) -> Unit,
    navController: NavController,
    onNavigateToFavorites: () -> Unit,
    favoritesViewModel: FavoritesViewModel,
    cartViewModel: CartViewModel
) {
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val filteredSneakers = availableSneakers.filter {
        it.model.contains(searchQuery, ignoreCase = true)
    }

    val favoriteSneakers by favoritesViewModel.favoriteItems.collectAsState(initial = emptyList())
    val cartItems by cartViewModel.cartItems.collectAsState(initial = emptyList())


    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize(),
        topBar = {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.arkk_banner),
                    contentDescription = "Arkk Copenhagen Banner",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.LightGray, shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search Icon",
                        tint = Color.DarkGray,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { keyboardController?.hide() }
                        ),
                        decorationBox = { innerTextField ->
                            if (searchQuery.isEmpty()) {
                                Text(
                                    text = "Search...",
                                    fontSize = 16.sp,
                                    color = Color.Gray
                                )
                            }
                            innerTextField()
                        }
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {

                item {
                    Image(
                        painter = painterResource(id = R.drawable.arkk_banner_2),
                        contentDescription = "Second Arkk Banner",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(136.dp)
                    )
                }

                itemsIndexed(filteredSneakers.chunked(2)) { _, sneakerPair ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        sneakerPair.forEach { sneaker ->
                            SneakerCard(
                                sneaker = sneaker,
                                onAddToCart = {
                                    onAddToCart(sneaker)
                                },
                                onAddToWishlist = {
                                    val isFavorite = favoriteSneakers.any { it.id == sneaker.id }
                                    Log.d(
                                        "HomeScreen",
                                        "Sneaker ${sneaker.id} isFavorite: $isFavorite"
                                    )
                                    if (!isFavorite) {
                                        val sneakerToAdd =
                                            sneaker.copy(isFavorite = true)
                                        favoritesViewModel.addToFavorites(sneakerToAdd)
                                        Log.d(
                                            "HomeScreen",
                                            "Adding Sneaker ${sneaker.id} to favorites"
                                        )
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Sneaker already in favorites",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                },
                                modifier = Modifier.weight(1f)
                            )
                        }

                        if (sneakerPair.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}