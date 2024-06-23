package com.adrian.cocktails.presentation.model

import com.adrian.domain.model.DrinkDto

data class DrinkCardItem(
    val name: String,
    val alcoholic: Boolean = false,
    val ingredients: List<String> = emptyList(),
    val image: String = ""
)

fun DrinkDto.toCard(): DrinkCardItem {
    return DrinkCardItem(
        name = this.name,
        alcoholic = this.alcoholic,
        ingredients = this.ingredients.map { it.name },
        image = this.imageSource ?: ""
    )
}