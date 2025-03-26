package com.deonvanooijen.sneakerapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.deonvanooijen.sneakerapp.data.database.CartDao
import com.deonvanooijen.sneakerapp.data.database.FavoritesDao
import com.deonvanooijen.sneakerapp.data.Sneaker

@Database(entities = [Sneaker::class], version = 1, exportSchema = false)
abstract class SneakerDatabase : RoomDatabase() {

    abstract fun cartDao(): CartDao
    abstract fun favoritesDao(): FavoritesDao

    companion object {
        @Volatile
        private var INSTANCE: SneakerDatabase? = null

        fun getDatabase(context: Context): SneakerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SneakerDatabase::class.java,
                    "sneaker_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}