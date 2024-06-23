package com.adrian.cocktails.application.di

import com.adrian.domain.provider.RepositoryProvider
import com.adrian.domain.repository.DrinksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CocktailsClient {

    @Singleton
    @Provides
    fun drinksRepository(): DrinksRepository = RepositoryProvider.drinksRepository

}