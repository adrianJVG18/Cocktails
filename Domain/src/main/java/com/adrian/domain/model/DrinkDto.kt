package com.adrian.domain.model

import com.adrian.data.model.remote.Drink

/**
 * Data transfer object, containing the Deserialization of [Drink]
 */
data class DrinkDto(
    val id: String,
    val name: String = "",
    val alternate: String?,
    val tags: String?,
    val video: String?,
    val category: String?,
    val IBA: String?,
    val alcoholic: Boolean = false,
    val glass: String?,
    val instructions: String?,
    val instructionsES: String?,
    val instructionsDE: String?,
    val instructionsFR: String?,
    val instructionsIT: String?,
    val instructionsZHHANS: String?,
    val instructionsZHHANT: String?,
    val drinkThumb: String?,
    val ingredients: List<IngredientDto> = emptyList(),
    val imageSource: String?,
    val imageAttribution: String?,
    val creativeCommonsConfirmed: String?,
    val dateModified: String?
)

/**
 * extension function of [Drink] that converts from [Drink] to [DrinkDto]
 */
fun Drink.toDto(): DrinkDto = DrinkDto(
    id = this.idDrink ?: "Unknown Id",
    name = this.strDrink ?: "",
    alternate = this.strDrinkAlternate,
    tags = this.strTags,
    video = this.strVideo,
    category = this.strCategory,
    IBA = this.strIBA,
    alcoholic = this.strAlcoholic == "Alcoholic" ,
    glass = this.strGlass,
    instructions = this.strInstructions,
    instructionsES = this.strInstructionsES,
    instructionsDE = this.strInstructionsDE,
    instructionsFR = this.strInstructionsFR,
    instructionsIT = this.strInstructionsIT,
    instructionsZHHANS = this.strInstructionsZHHANS,
    instructionsZHHANT = this.strInstructionsZHHANT,
    drinkThumb = this.strDrinkThumb,
    ingredients = getIngredients(drink = this),
    imageSource = this.strImageSource,
    imageAttribution = this.strImageAttribution,
    creativeCommonsConfirmed = this.strCreativeCommonsConfirmed,
    dateModified = this.dateModified
)

/**
 * Creates a list of [IngredientDto], from the ingredient and measure fields of the provided [Drink]
 */
private fun getIngredients(drink: Drink): List<IngredientDto> {
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