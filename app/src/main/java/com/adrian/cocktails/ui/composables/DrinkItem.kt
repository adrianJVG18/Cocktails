package com.adrian.cocktails.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrian.cocktails.presentation.model.DrinkCardItem

@Composable
fun DrinkCard(drink: DrinkCardItem) {
    Column(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.Black), RectangleShape)
            .background(Color.White)
            .defaultMinSize(minWidth = 176.dp)
    ) {
        // Title Text: Drink's name
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            overflow = TextOverflow.Ellipsis,
            minLines = 2,
            maxLines = 2,
            color = Color.Black,
            text = drink.name
        )

        if (drink.ingredients.isNotEmpty()) {
            // Ingredients Label
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                text = "Ingredients"
            )
            ItemizedGrid(items = drink.ingredients)
        }
    }
}

@Preview
@Composable
private fun PreviewNoIngredientDrinkCard() {
    DrinkCard(DrinkCardItem("Cool Margarita"))
}

@Preview
@Composable
private fun PreviewDrinkCardWithIngredients() {
    DrinkCard(DrinkCardItem("Cooler Margarita").apply {
        ingredients = listOf(
            "Triple sec",
            "Salt",
            "Lime Juice",
            "Tequila"
        )
    })
}

