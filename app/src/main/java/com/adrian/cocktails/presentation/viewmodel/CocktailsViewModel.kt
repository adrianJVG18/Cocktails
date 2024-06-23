package com.adrian.cocktails.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrian.commons.model.Response
import com.adrian.domain.repository.DrinksRepository
import com.adrian.cocktails.presentation.model.DrinkCardItem
import com.adrian.cocktails.presentation.model.toCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailsViewModel @Inject constructor(
    private val drinksRepository: DrinksRepository
) : ViewModel() {

    // _cocktails is only mutable-only within viewmodel. This is Backing Property of cocktails
    private val _cocktails: MutableStateFlow<Response<List<DrinkCardItem>>> =
        MutableStateFlow(Response.Loading(false))
    // cocktails is a public immutable property, therefore safe to be called outside of the viewmodel.
    // asStateFlow makes sure the mutable flow is "exposed" as a read-only StateFlow
    val cocktails: StateFlow<Response<List<DrinkCardItem>>> = _cocktails.asStateFlow()

    var typedText by mutableStateOf("")
        private set

    fun updateTypedText(typedText: String) {
        this.typedText = typedText
    }

    fun searchCocktailsByName() {
        viewModelScope.launch {
            drinksRepository.getDrinksByName(typedText).collect { response ->
                when(response){
                    is Response.Success ->
                        _cocktails.emit(Response.Success(response.data.map { it.toCard() }))
                    is Response.Failure ->
                        _cocktails.emit(Response.Failure(response.error, response.message))
                    is Response.Loading ->
                        _cocktails.emit(Response.Loading(response.isLoading))
                }
            }

        }
    }


}