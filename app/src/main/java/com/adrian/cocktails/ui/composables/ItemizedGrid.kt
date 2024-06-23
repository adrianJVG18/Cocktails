package com.adrian.cocktails.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrian.commons.ext.groupInPairs

@Composable
fun ItemizedGrid(items: List<String>) {
    Column {
        items.groupInPairs().forEach { pair ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .padding(start = 20.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    text = "• ${pair.first}"
                )
                pair.second?.let {
                    Text(
                        modifier = Modifier.weight(1f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        text = "• ${pair.second}"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemizedGridOfOneElement() {
    ItemizedGrid(items = listOf("Alcohol"))
}

@Preview(showBackground = true)
@Composable
fun PreviewItemizedGridOfTwoElements() {
    ItemizedGrid(items = listOf("Alcohol", "Coke"))
}

@Preview(showBackground = true)
@Composable
fun PreviewItemizedGridOfAquarium() {
    ItemizedGrid(items = listOf(
        "Vodka",
        "Rum",
        "White Wine",
        "Coke",
        "Fruit Punch",
        "Lemon Juice",
        "Artificial Blue Coloring"
    ))
}

