package com.adrian.domain.mocks

import com.adrian.data.model.remote.Drink
import java.util.ArrayList

object MockedDrinks {
    fun getDrinks(): ArrayList<Drink> = arrayListOf(
        Drink(
            idDrink = "13328",
            strDrink = "Chocolate Milk",
            strCategory = "Shot",
            strAlcoholic = "Alcoholic",
            strGlass = "Shot Glass",
            strInstructions = "Put the milk in the bottom, pour the Liquer on top and add the dash of amaretto. Do not mix. SLAM IT!",
            strInstructionsDE = "Die Milch auf den Boden geben, den Likör darüber gießen und den Spritzer Amaretto hinzufügen. Nicht mischen. SLAM IT!",
            strInstructionsIT = "Mettere sul fondo il latte, versarvi sopra il liquore e unire la spruzzata di amaretto.\r\nNon mescolare.",
            strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/j6q35t1504889399.jpg",
            strIngredient1 = "Chocolate liqueur",
            strIngredient2 = "Milk",
            strIngredient3 = "Amaretto",
            strMeasure1 = "1/2 shot",
            strMeasure2 = "1/2 shot",
            strMeasure3 = "1 dash",
            strCreativeCommonsConfirmed = "No",
            dateModified = "2017-09-08 17:49:59"
        ),
        Drink(
            idDrink = "12734",
            strDrink = "Chocolate Drink",
            strCategory = "Cocoa",
            strAlcoholic = "Non alcoholic",
            strGlass = "Coffee mug",
            strInstructions = "Melt the bar in a small amount of boiling water. Add milk. Cook over low heat, whipping gently (with a whisk, i would assume) until heated well. Don't let it boil! Serve in coffee mug.",
            strInstructionsDE = "Schmelzen Sie den Riegel in einer kleinen Menge kochendem Wasser. Milch zugeben. Bei schwacher Hitze kochen und dabei sanft (mit einem Schneebesen) aufschlagen, bis es gut erhitzt ist. Nicht aufkochen! In einer Kaffeetasse servieren.",
            strInstructionsIT = "Sciogliere la barretta in una piccola quantità di acqua bollente. Aggiungi il latte. Cuocere a fuoco basso, montando delicatamente con una frusta fino a quando non sarà ben riscaldato.Non farlo bollire! Servire in tazza da caffè.",
            strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/q7w4xu1487603180.jpg",
            strIngredient1 = "Chocolate",
            strIngredient2 = "Milk",
            strIngredient3 = "Water",
            strMeasure1 = "125 gr",
            strMeasure2 = "3/4 L ",
            strCreativeCommonsConfirmed = "No",
            dateModified = "2017-02-20 15:06:20"
        )
    )
}