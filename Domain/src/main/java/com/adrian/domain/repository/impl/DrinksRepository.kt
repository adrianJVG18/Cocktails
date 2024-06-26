package com.adrian.domain.repository.impl

import com.adrian.commons.model.Response
import com.adrian.data.service.DrinksService
import com.adrian.domain.model.DrinkDto
import com.adrian.domain.model.toDto
import com.adrian.domain.repository.DrinksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * DrinksRepository (Implementation) it's internal for this module,
 * and hidden for consumers of this module.
 */
internal class DrinksRepository(
    private val drinksService: DrinksService
): DrinksRepository {

    override fun getDrinksByName(name: String): Flow<Response<List<DrinkDto>>> = flow {
        emit(Response.Loading(true))
        emit(
            Response.Success(
            drinksService.getDrinksByName(name).drinks?.let { response ->
                response.map { it.toDto() }
            } ?: emptyList()
        ))
    }.catch {
        emit(Response.Failure(it as Exception, "${it.message}"))
    }
}