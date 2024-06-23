package com.adrian.data.client

import com.adrian.data.service.DrinksService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CocktailsClient {

    private const val BASE_URL = "https://www.thecocktaildb.com/api/"

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val drinkService: DrinksService
        get() = retrofit().create(DrinksService::class.java)
}