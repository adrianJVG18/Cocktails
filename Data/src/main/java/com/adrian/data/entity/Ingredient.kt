package com.adrian.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ingredients")
data class Ingredient (

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    @ColumnInfo(name = DRINK_ID)
    val drinkId: String,

    @ColumnInfo(name = NAME)
    val name: String,

    @ColumnInfo(name = MEASURE)
    val measure: String? = null

) {
    companion object {
        const val DRINK_ID = "DrinkId"
        const val NAME = "Name"
        const val MEASURE = "Measure"
    }
}