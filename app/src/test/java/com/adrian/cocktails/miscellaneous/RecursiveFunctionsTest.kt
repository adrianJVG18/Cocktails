package com.adrian.cocktails.miscellaneous

import org.junit.Test

class RecursiveFunctionsTest {

    val recursiveFunctions = RecursiveFunctions()

    @Test
    fun test_doSomething() {
        val result = recursiveFunctions.doSomething(x = 150000, y = 52500)
        assert(result == 150000 + 52500)
    }

}