package com.adrian.domain.repository.impl

import com.adrian.commons.model.Response
import com.adrian.data.dao.DrinksDao
import com.adrian.data.service.DrinksService
import com.adrian.domain.mappers.toDto
import com.adrian.domain.mappers.toEntity
import com.adrian.domain.model.DrinkDto
import com.adrian.domain.repository.DrinksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * DrinksRepository (Implementation) it's internal for this module,
 * and hidden for consumers of this module.
 */
internal class DrinksRepository(
    private val drinksService: DrinksService,
    private val drinksDao: DrinksDao
): DrinksRepository {

    override fun getDrinksByName(name: String): Flow<Response<List<DrinkDto>>> = flow {
        emit(Response.Loading(true))

        if (drinksDao.getDrinksByName(name).isEmpty()) {
            // Fetch remotely the Drinks
            val drinks = drinksService.getDrinksByName(name).drinks?.let { response ->
                response.map { it.toDto() }
            } ?: emptyList()
            emit(Response.Success(drinks))
            storeDrinks(drinks)
        } else {
            // Fetch from local database
            val drinks = drinksDao.getDrinksByName(name).map { it.toDto() }
            drinks.forEach {
                it.ingredients = drinksDao.getDrinkIngredients(it.id).map { ingredient ->
                    ingredient.toDto()
                }
            }
            emit(Response.Success(drinks))
        }

    }.catch {
        emit(Response.Failure(it as Exception, "${it.message}"))
    }

    private suspend fun storeDrinks(drinks: List<DrinkDto>) {
        drinksDao.insertDrinks(drinks.map { it.toEntity() })
        drinks.forEach { drink ->
            drinksDao.insertIngredients(drink.ingredients.map { it.toEntity(drink.id) })
        }
    }


}