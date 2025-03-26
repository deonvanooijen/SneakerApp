package com.deonvanooijen.sneakerapp.data.database

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deonvanooijen.sneakerapp.data.Sneaker
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM sneakers WHERE isInCart = 1")
    fun getCartItemsFlow(): Flow<List<Sneaker>>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun addToCart(sneaker: Sneaker) {
        Log.d("CartDao", "Inserting Sneaker with ID: ${sneaker.id} into cart.")
        val sneakerToInsert = sneaker.copy(isInCart = true, quantity = 1)
        insertSneaker(sneakerToInsert)
    }

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertSneaker(sneaker: Sneaker)

    @Query("UPDATE sneakers SET quantity = quantity + 1 WHERE id = :sneakerId AND isInCart = 1")
    suspend fun increaseQuantity(sneakerId: String)

    @Query("UPDATE sneakers SET quantity = quantity - 1 WHERE id = :sneakerId AND isInCart = 1 AND quantity > 1")
    suspend fun decreaseQuantity(sneakerId: String)

    @Query("UPDATE sneakers SET isInCart = 0, quantity = 0 WHERE id = :sneakerId")
    suspend fun removeFromCart(sneakerId: String)

    @Query("SELECT COUNT(*) FROM sneakers WHERE id = :sneakerId AND isInCart = 1")
    suspend fun isSneakerInCart(sneakerId: String): Int
}