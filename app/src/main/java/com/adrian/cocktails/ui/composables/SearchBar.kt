package com.adrian.cocktails.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrian.cocktails.R
import com.adrian.cocktails.ui.theme.CocktailsTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    input: String,
    onTextChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        val keyboardController = LocalSoftwareKeyboardController.current

        TextField(
            value = input,
            onValueChange = onTextChanged,
            // Makes the "enter" Key aware of the "Done" action
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            leadingIcon = {
                Image(
                    modifier = Modifier
                        .width(28.dp)
                        .height(28.dp),
                    painter = painterResource(id = R.drawable.search_24px),
                    contentDescription = "Icon of Magnifying glass to indicate Search",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
                )
            },
            placeholder = { Text(text = "Type Drink name", color = Color.Gray) },
            // Tells what to do "When" done
            keyboardActions = KeyboardActions(
                onSearch = { onKeyboardDone().also {
                    keyboardController?.hide()
                }}
            ),
            modifier = Modifier
                .height(50.dp)
                .weight(1f)
                .border(BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground), RectangleShape)
                .background(MaterialTheme.colorScheme.background)
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar_TypeChocolate() {
    CocktailsTheme {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(input = "Chocolate", onTextChanged = {}, onKeyboardDone = {})
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(name = "Light theme", showBackground = true)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSearchBar_Empty() {
    CocktailsTheme {
        Surface {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                SearchBar(input = "", onTextChanged = {}, onKeyboardDone = {})
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

