package com.naga.fetch.data.remote

import com.naga.fetch.data.model.RewardsItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Retrofit API service defining the endpoint to fetch items.
 */
interface RewardsService {

    /**
     * Retrieves the list of items from the remote API.
     *
     * @return A list of [RewardsItem] objects.
     */
    @GET("hiring.json")
    suspend fun getItems(): List<RewardsItem>
}

/**
 * Singleton object that provides a Retrofit client configured with
 * the base URL and Gson converter for JSON serialization.
 */
object ApiClient {

    private const val BASE_URL = "https://hiring.fetch.com/"

    val retrofit: RewardsService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RewardsService::class.java)
    }
}
