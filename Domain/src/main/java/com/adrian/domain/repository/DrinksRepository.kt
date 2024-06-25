package com.adrian.domain.repository

import com.adrian.commons.model.Response
import com.adrian.domain.model.DrinkDto
import kotlinx.coroutines.flow.Flow

/**
 * DrinksRepository (interface) it's the one public for outer-most layers, and it encapsulates
 * the actual implementation of this Repository.
 */
interface DrinksRepository {
    fun getDrinksByName(name: String): Flow<Response<List<DrinkDto>>>
}