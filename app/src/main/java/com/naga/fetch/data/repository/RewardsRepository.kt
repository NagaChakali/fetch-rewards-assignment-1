package com.naga.fetch.data.repository

import com.naga.fetch.data.model.RewardsItem
import com.naga.fetch.data.remote.RewardsService

/**
 * Repository responsible for fetching and organizing items from the API.
 *
 * @property api Retrofit service interface to fetch items.
 */
class RewardsRepository(private val api: RewardsService) {

    /**
     * Retrieves items from the API, filters out items with blank or null names,
     * sorts them by [listId] and then by [name], and groups the result by [listId].
     *
     * @return A map of list IDs to their corresponding sorted list of items.
     */
    suspend fun getSortedItems(): Map<Int, List<RewardsItem>> {
        return api.getItems()
            .filter { !it.name.isNullOrBlank() }
            .sortedWith(compareBy<RewardsItem> { it.listId }.thenBy { it.name })
            .groupBy { it.listId }
    }
}
