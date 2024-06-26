package com.adrian.domain.model

import com.adrian.data.model.Drink as DrinkModel

/**
 * Data transfer object, containing the Deserialization of [DrinkModel]
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
    var ingredients: List<IngredientDto> = emptyList(),
    val imageSource: String?,
    val imageAttribution: String?,
    val creativeCommonsConfirmed: String?,
    val dateModified: String?
)
