package com.adrian.cocktails.ui.composables

import android.content.res.Configuration
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
        Spacer(modifier = Modifier.height(8.dp))
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
                ConnectionErrorState()
            }
            is Response.Success -> {
                val drinks = (cocktails as Response.Success<List<DrinkCardItem>>).data
                DrinkCardsGrid(drinks = drinks)
            }
        }
    }
}

@Preview(name = "Light theme", showBackground = true)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDrinkSearchScreen_Grid() {
    PreviewDrinkCardsGrid()
}

@Preview(name = "Light theme", showBackground = true)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDrinkSearchScreen_EmptyDrinksState() {
    PreviewEmptyDrinksState()
}

@Preview(name = "Light theme", showBackground = true)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDrinkSearchScreen_ShowLoadingState() {
    PreviewShowLoadingState()
}

@Preview(name = "Light theme", showBackground = true)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDrinkSearchScreen_NoDrinksFoundState() {
    PreviewNoDrinksFoundState()
}

@Preview(name = "Light theme", showBackground = true)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDrinkSearchScreen_ConnectionErrorState() {
    PreviewConnectionErrorState()
}



