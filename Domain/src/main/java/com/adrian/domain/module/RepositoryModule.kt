package com.adrian.domain.module

import com.adrian.data.dao.DrinksDao
import com.adrian.data.service.DrinksService
import com.adrian.domain.repository.DrinksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.adrian.domain.repository.impl.DrinksRepository as DrinksRepositoryImpl

/**
 * This modules tells Hilt how are provided the Repositories of this Layer.
 *
 * If For Module/library design reasons, Hilt were removed, another Design pattern must be
 * implemented in order to provide an abstraction to this layer.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun drinksRepository(
        drinksService: DrinksService,
        drinksDao: DrinksDao
    ): DrinksRepository =
        DrinksRepositoryImpl(drinksService, drinksDao)

}