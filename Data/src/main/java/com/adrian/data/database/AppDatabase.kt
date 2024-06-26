package com.adrian.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adrian.data.dao.DrinksDao
import com.adrian.data.entity.Drink
import com.adrian.data.entity.Ingredient

@Database(
    entities = [
        Drink::class,
        Ingredient::class
               ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun drinksDao(): DrinksDao

}