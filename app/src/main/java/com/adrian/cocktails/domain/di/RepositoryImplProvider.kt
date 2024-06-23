package com.adrian.cocktails.domain.di

import com.adrian.cocktails.data.service.DrinksService
import com.adrian.cocktails.domain.repository.DrinksRepository
import com.adrian.cocktails.domain.repository.impl.DrinksRepository as DrinksRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryImplProvider {

    @Singleton
    @Provides
    fun drinksRepository(drinksService: DrinksService): DrinksRepository =
        DrinksRepositoryImpl(drinksService)

}