package com.adrian.domain.mappers

import com.adrian.data.entity.Ingredient
import com.adrian.data.model.Drink
import com.adrian.domain.model.IngredientDto

/**
 * Creates a list of [IngredientDto], from the ingredient and measure fields of the provided [Drink]
 */
fun getIngredients(drink: Drink): List<IngredientDto> {
    return listOf(
        Pair(drink.strIngredient1, drink.strMeasure1),
        Pair(drink.strIngredient2, drink.strMeasure2),
        Pair(drink.strIngredient3, drink.strMeasure3),
        Pair(drink.strIngredient4, drink.strMeasure4),
        Pair(drink.strIngredient5, drink.strMeasure5),
        Pair(drink.strIngredient6, drink.strMeasure6),
        Pair(drink.strIngredient7, drink.strMeasure7),
        Pair(drink.strIngredient8, drink.strMeasure8),
        Pair(drink.strIngredient9, drink.strMeasure9),
        Pair(drink.strIngredient10, drink.strMeasure10),
        Pair(drink.strIngredient11, drink.strMeasure11),
        Pair(drink.strIngredient12, drink.strMeasure12),
        Pair(drink.strIngredient13, drink.strMeasure13),
        Pair(drink.strIngredient14, drink.strMeasure14),
        Pair(drink.strIngredient15, drink.strMeasure15)
    ).filter { it.first != null } // Remove null ingredients
        .map { IngredientDto(it.first!!, it.second ?: "") }
}

fun IngredientDto.toEntity(drinkId: String): Ingredient = Ingredient(
    drinkId = drinkId,
    name = this.name,
    measure = this.measure
)

fun Ingredient.toDto(): IngredientDto = IngredientDto(
    name = this.name,
    measure = this.measure ?: ""
)