package com.adrian.cocktails.domain.repository.impl

import com.adrian.commons.model.Response
import com.adrian.cocktails.data.service.DrinksService
import com.adrian.cocktails.domain.model.DrinkDto
import com.adrian.cocktails.domain.model.toDto
import com.adrian.cocktails.domain.repository.DrinksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class DrinksRepository @Inject constructor(
    private val drinksService: DrinksService
): DrinksRepository {

    override fun getDrinksByName(name: String): Flow<Response<List<DrinkDto>>> = flow {
        emit(Response.Loading(true))
        emit(
            Response.Success(
            drinksService.getDrinksByName(name).drinks
                .map { it.toDto() }
        ))
    }.catch {
        emit(Response.Failure(it as Exception, "${it.message}"))
    }
}