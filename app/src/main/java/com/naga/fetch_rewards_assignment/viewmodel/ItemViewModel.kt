package com.naga.fetch_rewards_assignment.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naga.fetch_rewards_assignment.data.model.Item
import com.naga.fetch_rewards_assignment.data.remote.ApiClient
import com.naga.fetch_rewards_assignment.data.repository.ItemRepository
import kotlinx.coroutines.launch

/**
 * ViewModel responsible for fetching and exposing a grouped list of items.
 */
class ItemViewModel : ViewModel() {

    private val repository = ItemRepository(ApiClient.retrofit)

    /**
     * Grouped items mapped by their listId.
     */
    var items by mutableStateOf<Map<Int, List<Item>>>(emptyMap())
        private set

    /**
     * Error message if loading fails; null if no error.
     */
    var errorMessage by mutableStateOf<String?>(null)
        private set

    /**
     * True while data is being loaded.
     */
    var isLoading by mutableStateOf(true)
        private set

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            isLoading = true
            try {
                items = repository.getSortedItems()
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = "Failed to load items: ${e.localizedMessage ?: e.message}"
                items = emptyMap()
            } finally {
                isLoading = false
            }
        }
    }
}
