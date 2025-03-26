package com.deonvanooijen.sneakerapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deonvanooijen.sneakerapp.data.Sneaker
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM sneakers WHERE isFavorite = 1")
    fun getFavoriteItemsFlow(): Flow<List<Sneaker>>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun addToFavorites(sneaker: Sneaker)

    @Query("UPDATE sneakers SET isFavorite = 0 WHERE id = :sneakerId")
    suspend fun removeFromFavorites(sneakerId: String)

    @Query("SELECT COUNT(*) FROM sneakers WHERE id = :sneakerId AND isFavorite = 1")
    suspend fun isSneakerInFavorites(sneakerId: String): Int
}