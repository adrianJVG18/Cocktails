package com.adrian.cocktails.data.model

import com.google.gson.annotations.SerializedName

data class DrinksResponse (
    @SerializedName("drinks") var drinks : ArrayList<Drink> = arrayListOf()
)