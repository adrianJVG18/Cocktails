package com.adrian.data.service

import com.adrian.data.model.DrinksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksService {
    @GET("json/v1/1/search.php?")
    suspend fun getDrinksByName(
        @Query("s") name: String
    ): DrinksResponse
}