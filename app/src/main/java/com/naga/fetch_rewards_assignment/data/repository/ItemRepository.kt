package com.naga.fetch_rewards_assignment.data.repository

import com.naga.fetch_rewards_assignment.data.model.Item
import com.naga.fetch_rewards_assignment.data.remote.ApiService

/**
 * Repository responsible for fetching and organizing items from the API.
 *
 * @property api Retrofit service interface to fetch items.
 */
class ItemRepository(private val api: ApiService) {

    /**
     * Retrieves items from the API, filters out items with blank or null names,
     * sorts them by [listId] and then by [name], and groups the result by [listId].
     *
     * @return A map of list IDs to their corresponding sorted list of items.
     */
    suspend fun getSortedItems(): Map<Int, List<Item>> {
        return api.getItems()
            .filter { !it.name.isNullOrBlank() }
            .sortedWith(compareBy<Item> { it.listId }.thenBy { it.name })
            .groupBy { it.listId }
    }
}
