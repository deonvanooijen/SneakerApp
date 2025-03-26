package com.deonvanooijen.sneakerapp.data

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sneakers")
data class Sneaker(
    @PrimaryKey val id: String,
    val imageResId: Int,
    val brand: String,
    val model: String,
    val stock: StockLevel,
    val retailPrice: Double,
    @DrawableRes val logoResId: Int,
    val quantity: Int = 1,
    val isFavorite: Boolean = false,
    val isInCart: Boolean = false
)

enum class StockLevel { LOW, MEDIUM, HIGH }