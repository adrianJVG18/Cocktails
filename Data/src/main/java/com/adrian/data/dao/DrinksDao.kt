package com.adrian.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrian.data.entity.Drink
import com.adrian.data.entity.Ingredient

@Dao
interface DrinksDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDrinks(drinks: List<Drink>): List<Long>

    @Query("SELECT * " +
            "FROM Drinks " +
            "WHERE Name LIKE '%' || :name || '%'")
    suspend fun getDrinksByName(name: String): List<Drink>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIngredients(ingredients: List<Ingredient>): List<Long>

    @Query("SELECT * " +
            "FROM Ingredients " +
            "WHERE ${Ingredient.DRINK_ID} LIKE :drinkId")
    suspend fun getDrinkIngredients(drinkId: String): List<Ingredient>

}