package com.adrian.domain.client

import com.adrian.data.service.DrinksService
import com.adrian.domain.repository.DrinksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.adrian.domain.repository.impl.DrinksRepository as DrinksRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun drinksRepository(drinksService: DrinksService): DrinksRepository =
        DrinksRepositoryImpl(drinksService)

}