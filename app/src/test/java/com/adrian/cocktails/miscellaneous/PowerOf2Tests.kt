package com.adrian.cocktails.miscellaneous

import org.junit.Assert.assertEquals
import org.junit.Test

class PowerOf2Tests {

    @Test
    fun `when getPowerOf2 from 1 then return 0`() {
        val tournament = Tournament(emptyList())

        assertEquals(0, tournament.getPowerOf2(1))
    }

    @Test
    fun `when getPowerOf2 from 2 then return 1`() {
        val tournament = Tournament(emptyList())

        assertEquals(1, tournament.getPowerOf2(2))
    }

    @Test
    fun `when getPowerOf2 from 3 then return 1`() {
        val tournament = Tournament(emptyList())

        assertEquals(1, tournament.getPowerOf2(3))
    }

    @Test
    fun `when getPowerOf2 from 4 then return 2`() {
        val tournament = Tournament(emptyList())

        assertEquals(2, tournament.getPowerOf2(4))
    }

    @Test
    fun `when getPowerOf2 from 16 then return 4`() {
        val tournament = Tournament(emptyList())

        assertEquals(4, tournament.getPowerOf2(16))
    }

    @Test
    fun `when getPowerOf2 from 31 then return 4`() {
        val tournament = Tournament(emptyList())

        assertEquals(4, tournament.getPowerOf2(31))
    }

    @Test
    fun `when getPowerOf2 from 33 then return 5`() {
        val tournament = Tournament(emptyList())

        assertEquals(4, tournament.getPowerOf2(31))
    }
}