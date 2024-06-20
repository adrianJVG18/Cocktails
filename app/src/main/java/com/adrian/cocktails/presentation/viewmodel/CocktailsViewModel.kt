package com.adrian.cocktails.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.adrian.cocktails.commons.Response
import com.adrian.cocktails.presentation.model.Drink
import com.adrian.cocktails.domain.usecase.FetchCocktailsByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CocktailsViewModel @Inject constructor(
    private val fetchCocktailsByNameUseCase: FetchCocktailsByNameUseCase
) : ViewModel() {

    private val _cocktails: MutableStateFlow<Response<List<Drink>>> =
        MutableStateFlow(Response.Loading(false))
    val cocktails: StateFlow<Response<List<Drink>>> = _cocktails

    fun searchCocktailsByName(name: String) {

    }

}