package com.adrian.cocktails.miscellaneous

class RecursiveFunctions {

    // a and b are positive integers
    fun doSomething(x: Int, y: Int): Int {
        if (x == 0) return y
        return doSomething(x - 1, y + x)
    }

}