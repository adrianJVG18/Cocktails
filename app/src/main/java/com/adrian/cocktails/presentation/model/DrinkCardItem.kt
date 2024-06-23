package com.adrian.cocktails.presentation.model

import com.adrian.cocktails.domain.model.DrinkDto

data class DrinkCardItem(
    val name: String
) {
    var ingredients: List<String> = emptyList()
}

fun DrinkDto.toCard(): DrinkCardItem {
    return DrinkCardItem(
        this.name
    )
}