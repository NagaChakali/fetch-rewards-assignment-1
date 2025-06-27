package com.naga.fetch.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.naga.fetch.presentation.ui.components.RewardsCard
import com.naga.fetch.presentation.RewardsViewModel

/**
 * Displays a list of items grouped by their listId.
 *
 * Shows a loading indicator while fetching data,
 * an error message if something goes wrong,
 * and the grouped items once loaded.
 */
@Composable
fun ItemListScreen(viewModel: RewardsViewModel) {
    val itemsByListId = viewModel.items
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    when {
        isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        error != null -> {
            Text(
                text = error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        else -> {
            LazyColumn(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Screen title
                item {
                    Text(
                        text = "User List",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        textAlign = TextAlign.Center
                    )
                }

                // Display each group of items
                itemsByListId.forEach { (listId, items) ->
                    // Group header
                    item {
                        Text(
                            text = "List ID: $listId",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    // Items in this group
                    items(items) { item ->
                        RewardsCard(item)
                    }
                }
            }
        }
    }
}
