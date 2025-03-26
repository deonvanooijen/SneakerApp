package com.deonvanooijen.sneakerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.deonvanooijen.sneakerapp.data.Sneaker
import com.deonvanooijen.sneakerapp.data.database.SneakerDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val db = SneakerDatabase.Companion.getDatabase(application)
    private val favoritesDao = db.favoritesDao()

    val favoriteItems: Flow<List<Sneaker>> = favoritesDao.getFavoriteItemsFlow()

    fun addToFavorites(sneaker: Sneaker) {
        viewModelScope.launch {
            favoritesDao.addToFavorites(sneaker)
        }
    }

    fun removeFromFavorites(sneaker: Sneaker) {
        viewModelScope.launch {
            favoritesDao.removeFromFavorites(sneaker.id)
        }
    }
}