package com.adrian.cocktails.data.client

import com.adrian.cocktails.data.service.DrinksService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CocktailsClient {

    private const val BASE_URL = "https://www.thecocktaildb.com/api/"

    @Singleton
    @Provides
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun drinkService(retrofit: Retrofit): DrinksService {
        return retrofit.create(DrinksService::class.java)
    }
}