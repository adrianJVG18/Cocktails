package com.adrian.cocktails.domain.usecase

import com.adrian.cocktails.commons.Response
import com.adrian.cocktails.data.model.Drink
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchCocktailsByNameUseCase @Inject constructor() : FetchCocktails {

    override suspend fun execute(params: String?): Flow<Response<Drink>> = flow {

    }

}