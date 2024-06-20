package com.adrian.cocktails.domain.usecase

import com.adrian.cocktails.commons.Response
import kotlinx.coroutines.flow.Flow

interface Usecase<Params, Result> {
    suspend fun execute(params: Params? = null): Flow<Response<Result>>
}