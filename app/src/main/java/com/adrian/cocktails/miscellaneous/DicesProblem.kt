package com.adrian.cocktails.miscellaneous

import java.util.Date
import kotlin.random.Random

class Dice(var value: Int) {
    // By using as seed "Date().time", at least we assuring avoid using the
    // the same seed for each time we call "roll()"
    fun roll(isCheated: Boolean) {
        value = if (isCheated) 6
        else Random(seed = Date().time).nextInt(1, 7)
    }
}


class DiceRoller(val diceList: ArrayList<Dice>, val isCheated: Boolean) {
    fun roll(): ArrayList<Dice> {
        diceList.forEach { dice ->
            dice.roll(isCheated)
        }
        return diceList
    }
}