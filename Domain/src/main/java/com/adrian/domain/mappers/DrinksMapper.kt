package com.adrian.domain.mappers

import com.adrian.data.model.Drink
import com.adrian.domain.model.DrinkDto
import com.adrian.data.entity.Drink as DrinkEntity

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
 * extension function of [DrinkDto] that converts from [DrinkDto] to [DrinkEntity]
 */
fun DrinkDto.toEntity(): DrinkEntity = DrinkEntity(
    id = this.id.toLong(),
    name = this.name,
    alternate = this.alternate,
    tags = this.tags,
    video = this.video,
    category = this.category,
    iba = this.IBA,
    alcoholic = this.alcoholic,
    glass = this.glass,
    instructions = this.instructions,
    instructionsES = this.instructionsES,
    instructionsDE = this.instructionsDE,
    instructionsFR = this.instructionsFR,
    instructionsIT = this.instructionsIT,
    instructionsZHHANS = this.instructionsZHHANS,
    instructionsZHHANT = this.instructionsZHHANT,
    thumb = this.drinkThumb,
    imageSource = this.imageSource, imageAttribution = this.imageAttribution,
    creativeCommonsConfirmed = this.creativeCommonsConfirmed,
    dateModified = this.dateModified
)

/**
 * extension function of [DrinkEntity] that converts from [DrinkEntity] to [DrinkDto]
 */
fun DrinkEntity.toDto(): DrinkDto = DrinkDto(
    id = "${this.id}",
    name = this.name ?: "",alternate = this.alternate,
    tags = this.tags,
    video = this.video,
    category = this.category,
    IBA = this.iba,
    alcoholic = this.alcoholic ?: false,
    glass = this.glass,
    instructions = this.instructions,
    instructionsES = this.instructionsES,
    instructionsDE = this.instructionsDE,
    instructionsFR = this.instructionsFR,
    instructionsIT = this.instructionsIT,
    instructionsZHHANS = this.instructionsZHHANS,
    instructionsZHHANT = this.instructionsZHHANT,
    drinkThumb = this.thumb,
    ingredients = emptyList(),
    imageSource = this.imageSource,
    imageAttribution = this.imageAttribution,
    creativeCommonsConfirmed = this.creativeCommonsConfirmed,
    dateModified= this.dateModified
)
