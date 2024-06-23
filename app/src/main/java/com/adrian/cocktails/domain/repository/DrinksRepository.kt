package com.adrian.cocktails.domain.repository

import com.adrian.commons.model.Response
import com.adrian.cocktails.domain.model.DrinkDto
import kotlinx.coroutines.flow.Flow

interface DrinksRepository {
    fun getDrinksByName(name: String): Flow<Response<List<DrinkDto>>>
}