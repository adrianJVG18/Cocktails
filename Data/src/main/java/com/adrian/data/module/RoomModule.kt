package com.adrian.data.module

import android.content.Context
import androidx.room.Room
import com.adrian.data.dao.DrinksDao
import com.adrian.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * This modules tells Hilt how are provided the dependencies related to Retrofit on this Layer.
 *
 * If For Module/library design reasons, Hilt were removed, another Design pattern must be
 * implemented in order to provide an abstraction to this layer.
 */
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun database(@ApplicationContext applicationContext: Context): AppDatabase =
        Room.databaseBuilder(
            context = applicationContext,
            klass = AppDatabase::class.java,
            name = "Cocktails"
        ).build()

    @Singleton
    @Provides
    fun drinksDao(database: AppDatabase): DrinksDao =
        database.drinksDao()

}