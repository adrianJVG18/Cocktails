package com.adrian.cocktails.domain.di

import com.adrian.data.service.DrinksService
import com.adrian.cocktails.domain.repository.DrinksRepository
import com.adrian.data.client.CocktailsClient
import com.adrian.cocktails.domain.repository.impl.DrinksRepository as DrinksRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryImplProvider {

    @Singleton
    @Provides
    fun drinksService(): DrinksService = CocktailsClient.drinkService

    @Singleton
    @Provides
    fun drinksRepository(drinksService: DrinksService): DrinksRepository =
        DrinksRepositoryImpl(drinksService)

}