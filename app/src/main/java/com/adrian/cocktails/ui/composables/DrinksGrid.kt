package com.adrian.cocktails.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrian.cocktails.presentation.model.DrinkCardItem
import com.adrian.cocktails.ui.theme.CocktailsTheme

@Composable
fun DrinkCardsGrid(drinks: List<DrinkCardItem>) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier.padding(8.dp),
        columns = StaggeredGridCells.Adaptive(minSize = 176.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            drinks.forEach {
                item {
                    DrinkCard(drink = it)
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewDrinkCardsGrid() {
    CocktailsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                SearchBar(input = "Margarita", onTextChanged = {}, onKeyboardDone = {})
                Spacer(modifier = Modifier.height(8.dp))
                DrinkCardsGrid(drinks = getPreviewDrinkCards())
            }
        }
    }
}

fun getPreviewDrinkCards(): List<DrinkCardItem> {
    return listOf(
        DrinkCardItem(name = "Margarita", ingredients = listOf(
            "Triple sec",
            "Salt",
            "Lime Juice",
            "Tequila"
        )),
        DrinkCardItem(name = "Hot Chocolate", ingredients = listOf(
            "Chocolate",
            "Milk",
            "Water",
        )),
        DrinkCardItem("Something drinkable with a long ass name"),
        DrinkCardItem("Royal Flush", ingredients = listOf(
            "etc", "more etc", "double etc"
        ))
    )
}