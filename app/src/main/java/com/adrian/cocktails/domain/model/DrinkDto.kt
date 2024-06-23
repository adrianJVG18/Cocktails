package com.adrian.cocktails.domain.model

import com.adrian.cocktails.data.model.Drink

data class DrinkDto(
    val name: String
)

fun Drink.toDto(): DrinkDto = DrinkDto(
    name =  this.strDrink ?: ""
)