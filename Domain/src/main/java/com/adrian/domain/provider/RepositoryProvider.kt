package com.adrian.domain.provider

import com.adrian.data.client.CocktailsClient
import com.adrian.domain.repository.DrinksRepository
import com.adrian.domain.repository.impl.DrinksRepository as DrinksRepositoryImpl

object RepositoryProvider {
    val drinksRepository: DrinksRepository = DrinksRepositoryImpl(CocktailsClient.drinkService)
}