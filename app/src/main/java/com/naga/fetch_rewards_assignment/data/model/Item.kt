package com.naga.fetch_rewards_assignment.data.model

/**
 * Data model representing a single item from the API response.
 *
 * @property id Unique identifier for the item.
 * @property listId Identifier of the list this item belongs to.
 * @property name Name of the item. Can be null if absent in the API.
 */
data class Item(
    val id: Int,
    val listId: Int,
    val name: String?
)
