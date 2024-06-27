package com.adrian.domain.repository.impl

import com.adrian.commons.model.Response
import com.adrian.data.dao.DrinksDao
import com.adrian.data.entity.Drink as DrinkEntity
import com.adrian.data.model.DrinksResponse
import com.adrian.data.service.DrinksService
import com.adrian.domain.mocks.MockedDrinks
import com.adrian.domain.repository.DrinksRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
import com.adrian.domain.repository.impl.DrinksRepository as DrinksRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.anyList
import org.mockito.Mockito.anyString
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DrinksRepositoryTest {

    @Mock
    private lateinit var drinksService: DrinksService
    @Mock
    private lateinit var drinksDao: DrinksDao

    private lateinit var drinksRepository: DrinksRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(DrinksRepositoryTest::class)
        drinksRepository = DrinksRepositoryImpl(drinksService, drinksDao)
    }

    @Test
    fun `when drinks by name is called then emit at least once Loading state`(): Unit = runBlocking {
        val flux = drinksRepository.getDrinksByName("Chocolate").toList()

        assertTrue(flux[0] is Response.Loading)
        assertTrue((flux[0] as Response.Loading).isLoading)
    }

    @Test
    fun `when drinks by name is called successfully then emit list of DrinkDto`(): Unit = runBlocking {
        val mockedResponse = DrinksResponse().apply { drinks = MockedDrinks.getDrinks() }
        doReturn(mockedResponse).`when`(drinksService).getDrinksByName(anyString())
        doReturn(emptyList<DrinkEntity>()).`when`(drinksDao).getDrinksByName(anyString())
        doReturn(emptyList<Long>()).`when`(drinksDao).insertDrinks(anyList())
        doReturn(emptyList<Long>()).`when`(drinksDao).insertIngredients(anyList())

        val flux = drinksRepository.getDrinksByName("Chocolate").toList()

        assertTrue(flux[0] is Response.Loading)
        assertTrue((flux[0] as Response.Loading).isLoading)
        assertTrue(flux[1] is Response.Success)
        assertTrue((flux[1] as Response.Success).data.isNotEmpty())
        assertEquals("13328", (flux[1] as Response.Success).data[0].id)
        assertEquals(3, (flux[1] as Response.Success).data[0].ingredients.size)
        assertEquals("12734", (flux[1] as Response.Success).data[1].id)
        assertEquals(3, (flux[1] as Response.Success).data[1].ingredients.size)
        assertEquals("", (flux[1] as Response.Success).data[1].ingredients[2].measure)
    }

    @Test
    fun `when drinks by name is called successfully but no result is found then emit emptyList`(): Unit = runBlocking {
        val mockedResponse = DrinksResponse().apply { drinks = arrayListOf() }
        doReturn(mockedResponse).`when`(drinksService).getDrinksByName(anyString())
        doReturn(emptyList<DrinkEntity>()).`when`(drinksDao).getDrinksByName(anyString())
        doReturn(emptyList<Long>()).`when`(drinksDao).insertDrinks(anyList())

        val flux = drinksRepository.getDrinksByName("Chocolate").toList()

        assertTrue(flux[0] is Response.Loading)
        assertTrue((flux[0] as Response.Loading).isLoading)
        assertTrue(flux[1] is Response.Success)
        assertTrue((flux[1] as Response.Success).data.isEmpty())
    }

}