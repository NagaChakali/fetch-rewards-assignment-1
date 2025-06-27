package com.naga.fetch_rewards_assignment.data.remote

import com.naga.fetch_rewards_assignment.data.model.Item
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Retrofit API service defining the endpoint to fetch items.
 */
interface ApiService {

    /**
     * Retrieves the list of items from the remote API.
     *
     * @return A list of [Item] objects.
     */
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}

/**
 * Singleton object that provides a Retrofit client configured with
 * the base URL and Gson converter for JSON serialization.
 */
object ApiClient {

    private const val BASE_URL = "https://hiring.fetch.com/"

    val retrofit: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
