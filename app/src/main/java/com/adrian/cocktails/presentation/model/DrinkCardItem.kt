package com.adrian.cocktails.presentation.model

import com.adrian.domain.model.DrinkDto

/**
 * data class that contains the minimal information needed to display a Card of a Drink.
 */
data class DrinkCardItem(
    val name: String,
    val alcoholic: Boolean = false,
    val ingredients: List<String> = emptyList(),
    val image: String = ""
)

/**
 * Extension function of [DrinkDto] that maps from itself to [DrinkCardItem]
 */
fun DrinkDto.toCard(): DrinkCardItem {
    return DrinkCardItem(
        name = this.name,
        alcoholic = this.alcoholic,
        ingredients = this.ingredients.map { it.name },
        image = this.drinkThumb ?: ""
    )
}