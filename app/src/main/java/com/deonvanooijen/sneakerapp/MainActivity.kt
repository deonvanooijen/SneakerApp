package com.deonvanooijen.sneakerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deonvanooijen.sneakerapp.data.database.SneakerDatabase
import com.deonvanooijen.sneakerapp.ui.CartScreen
import com.deonvanooijen.sneakerapp.ui.FavoritesScreen
import com.deonvanooijen.sneakerapp.ui.HomeScreen
import com.deonvanooijen.sneakerapp.ui.ProfileScreen
import com.deonvanooijen.sneakerapp.ui.WelcomeScreen
import com.deonvanooijen.sneakerapp.ui.theme.SneakerAppTheme
import com.deonvanooijen.sneakerapp.viewmodel.CartViewModel
import com.deonvanooijen.sneakerapp.viewmodel.CartViewModelFactory
import com.deonvanooijen.sneakerapp.viewmodel.FavoritesViewModel
import getSneakers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SneakerAppTheme {
                val navController = rememberNavController()

                val cartDao = SneakerDatabase.Companion.getDatabase(applicationContext).cartDao()

                val cartViewModel: CartViewModel = ViewModelProvider(
                    this,
                    CartViewModelFactory(cartDao)
                ).get(CartViewModel::class.java)

                val favoritesViewModel: FavoritesViewModel = viewModel() // ViewModel for favorites

                NavHost(
                    navController = navController,
                    startDestination = "welcomeScreen"
                ) {
                    // Welcome Screen
                    composable("welcomeScreen") {
                        WelcomeScreen(
                            onGetStarted = {
                                navController.navigate("homeScreen")
                            }
                        )
                    }

                    // Home Screen
                    composable("homeScreen") {
                        HomeScreen(
                            availableSneakers = getSneakers(),
                            onAddToCart = { sneaker -> cartViewModel.addToCart(sneaker) },
                            onAddToWishlist = { sneaker -> favoritesViewModel.addToFavorites(sneaker) },
                            navController = navController,
                            onNavigateToFavorites = { navController.navigate("favoritesScreen") },
                            favoritesViewModel = favoritesViewModel,
                            cartViewModel = cartViewModel
                        )
                    }

                    // Cart Screen
                    composable("cartScreen") {
                        CartScreen(
                            navController = navController,
                            cartViewModel = cartViewModel,
                            onRemoveFromCart = { sneaker -> cartViewModel.removeFromCart(sneaker) },
                            onIncreaseQuantity = { sneaker -> cartViewModel.increaseQuantity(sneaker) },
                            onDecreaseQuantity = { sneaker -> cartViewModel.decreaseQuantity(sneaker) }
                        )
                    }

                    // Favorites Screen
                    composable("favoritesScreen") {
                        FavoritesScreen(
                            navController = navController,
                            favoritesViewModel = favoritesViewModel
                        )
                    }

                    // Profile Screen
                    composable("profileScreen") {
                        ProfileScreen(navController = navController)
                    }
                }
            }
        }
    }
}