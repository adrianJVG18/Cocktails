package com.adrian.cocktails.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrian.commons.model.Response
import com.adrian.cocktails.presentation.model.DrinkCardItem
import com.adrian.cocktails.presentation.viewmodel.CocktailsViewModel

@Composable
fun DrinkSearchScreen(cocktailsViewModel: CocktailsViewModel) {

    val cocktails by cocktailsViewModel.cocktails.collectAsState()

    Column {
        SearchBar(
            input = cocktailsViewModel.typedText,
            onKeyboardDone = { cocktailsViewModel.searchCocktailsByName() },
            onTextChanged = { cocktailsViewModel.updateTypedText(it) }
        )
        Spacer(modifier = Modifier.height(8.dp))

        when (cocktails) {
            is Response.Loading -> {
                if ((cocktails as Response.Loading<List<DrinkCardItem>>).isLoading) {
                    ShowLoadingState(isLoading = true)
                } else {
                    EmptyDrinksState()
                }
            }
            is Response.Failure -> {
                // Here it's going to be added better error communication to the User
                NoDrinksFoundState()
            }
            is Response.Success -> {
                val drinks = (cocktails as Response.Success<List<DrinkCardItem>>).data
                DrinkCardsGrid(drinks = drinks)
            }
        }
    }
}

@Preview
@Composable
fun PreviewDrinkSearchScreen_Grid() {
    PreviewDrinkCardsGrid()
}

@Preview
@Composable
fun PreviewDrinkSearchScreen_EmptyDrinksState() {
    PreviewEmptyDrinksState()
}

@Preview
@Composable
fun PreviewDrinkSearchScreen_ShowLoadingState() {
    PreviewShowLoadingState()
}

@Preview
@Composable
fun PreviewDrinkSearchScreen_NoDrinksFoundState() {
    PreviewNoDrinksFoundState()
}

