package com.adrian.cocktails.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrian.cocktails.presentation.viewmodel.CocktailsViewModel
import com.adrian.cocktails.ui.composables.DrinkCardsGrid
import com.adrian.cocktails.ui.composables.DrinkSearchScreen
import com.adrian.cocktails.ui.composables.SearchBar
import com.adrian.cocktails.ui.composables.getPreviewDrinkCards
import com.adrian.cocktails.ui.theme.CocktailsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val cocktailsViewModel: CocktailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CocktailsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DrinkSearchScreen(cocktailsViewModel = cocktailsViewModel)
                }
            }
        }

    }
}

@Preview
@Composable
private fun PreviewMainActivity() {
    CocktailsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                SearchBar(input = "", onTextChanged = {}, onKeyboardDone = {})
                Spacer(modifier = Modifier.height(8.dp))
                DrinkCardsGrid(drinks = getPreviewDrinkCards())
            }

        }
    }
}