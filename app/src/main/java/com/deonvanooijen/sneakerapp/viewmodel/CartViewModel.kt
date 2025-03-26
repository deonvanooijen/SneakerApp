package com.deonvanooijen.sneakerapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deonvanooijen.sneakerapp.data.database.CartDao
import com.deonvanooijen.sneakerapp.data.CartItem
import com.deonvanooijen.sneakerapp.data.Sneaker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CartViewModel(private val cartDao: CartDao) : ViewModel() {

    val cartItems: Flow<List<CartItem>> = cartDao.getCartItemsFlow().map { sneakers ->
        sneakers.map { sneaker ->
            CartItem(
                sneaker = sneaker,
                quantity = sneaker.quantity
            )
        }
    }

    fun addToCart(sneaker: Sneaker) {
        viewModelScope.launch {
            val isInCart = cartDao.isSneakerInCart(sneaker.id)
            Log.d("CartViewModel", "Is Sneaker in Cart: $isInCart")

            if (isInCart == 0) {
                Log.d("CartViewModel", "Adding Sneaker to Cart: ${sneaker.id}")
                cartDao.addToCart(sneaker)  // Pass sneakerId to the DAO
            } else {
                Log.d("CartViewModel", "Increasing Quantity for Sneaker: ${sneaker.id}")
                cartDao.increaseQuantity(sneaker.id)
            }

            Log.d("CartViewModel", "Sneaker added to cart, flow will be updated.")
        }
    }

    fun increaseQuantity(sneaker: Sneaker) {
        viewModelScope.launch {
            cartDao.increaseQuantity(sneaker.id)
        }
    }

    fun decreaseQuantity(sneaker: Sneaker) {
        viewModelScope.launch {
            cartDao.decreaseQuantity(sneaker.id)
        }
    }

    fun removeFromCart(sneaker: Sneaker) {
        viewModelScope.launch {
            cartDao.removeFromCart(sneaker.id)
        }
    }
}