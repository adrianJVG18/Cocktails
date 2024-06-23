package com.adrian.cocktails.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    input: String,
    onTextChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit
) {
    Row(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.Black), RectangleShape)
            .wrapContentSize()
            .padding(horizontal = 8.dp)
    ) {
        val keyboardController = LocalSoftwareKeyboardController.current

        TextField(
            value = input,
            onValueChange = onTextChanged,
            // Makes the "enter" Key aware of the "Done" action
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            // Tells what to do "When" done
            keyboardActions = KeyboardActions(
                onSearch = { onKeyboardDone().also {
                    keyboardController?.hide()
                }}
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Transparent)

        )
    }
}
