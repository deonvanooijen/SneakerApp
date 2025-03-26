package com.deonvanooijen.sneakerapp.ui

import CartItemView
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavController
import com.deonvanooijen.sneakerapp.viewmodel.CartViewModel
import com.deonvanooijen.sneakerapp.ui.components.BottomNavigationBar
import com.deonvanooijen.sneakerapp.ui.components.BottomSection
import com.deonvanooijen.sneakerapp.ui.components.TopSection
import com.deonvanooijen.sneakerapp.data.Sneaker

@Composable
fun CartScreen(
    navController: NavController,
    cartViewModel: CartViewModel,
    onRemoveFromCart: (Sneaker) -> Unit,
    onIncreaseQuantity: (Sneaker) -> Unit,
    onDecreaseQuantity: (Sneaker) -> Unit
) {
    val cartItems by cartViewModel.cartItems.collectAsState(initial = emptyList())

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopSection(title = "My Cart") },
        bottomBar = {
            Column {
                BottomSection(cartItems = cartItems)
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (cartItems.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Your cart is empty",
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(cartItems) { cartItem ->

                        CartItemView(
                            sneaker = cartItem.sneaker,
                            quantity = cartItem.quantity,
                            onIncreaseQuantity = { onIncreaseQuantity(cartItem.sneaker) },
                            onDecreaseQuantity = { onDecreaseQuantity(cartItem.sneaker) },
                            onRemoveFromCart = { onRemoveFromCart(cartItem.sneaker) }
                        )
                    }
                }
            }
        }
    }
}