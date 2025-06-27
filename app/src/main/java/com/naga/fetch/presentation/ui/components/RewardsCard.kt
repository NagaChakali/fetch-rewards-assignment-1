package com.naga.fetch.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.naga.fetch.data.model.RewardsItem

/**
 * Simple card component that displays an item's name.
 * If the name is null, shows an empty string.
 */
@Composable
fun RewardsCard(item: RewardsItem ) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            // Provide semantics for accessibility
            .semantics {
                contentDescription = item.name ?: "Unnamed item"
            }
    ) {
        Text(
            text = item.name ?: "",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}
