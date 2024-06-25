package com.adrian.data.module

import com.adrian.data.service.DrinksService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * This modules tells Hilt how are provided the dependencies related to Retrofit on this Layer.
 *
 * If For Module/library design reasons, Hilt were removed, another Design pattern must be
 * implemented in order to provide an abstraction to this layer.
 */
@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

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
    fun drinkService(retrofit: Retrofit): DrinksService =
        retrofit.create(DrinksService::class.java)
}