package com.adrian.cocktails.miscellaneous

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.random.Random

class TennisTournamentTest {

    @Test
    fun `tournament validation for 4 participants, leaves in 4 players`() {
        val tournament = Tournament(getPlayers(4))

        tournament.validateParticipants()

        assertEquals(4, tournament.players.size)
    }

    @Test
    fun `tournament validation for 7 participants, leaves in 4 players`() {
        val tournament = Tournament(getPlayers(7))

        tournament.validateParticipants()

        assertEquals(4, tournament.players.size)

    }

    @Test
    fun `tournament validation for 9 participants, leaves in 8 players`() {
        val tournament = Tournament(getPlayers(9))

        tournament.validateParticipants()

        assertEquals(8, tournament.players.size)
    }

    @Test
    fun `tournament validation for 255 participants, leaves in 126 players`() {
        val tournament = Tournament(getPlayers(255))

        tournament.validateParticipants()

        assertEquals(128, tournament.players.size)
    }

    @Test
    fun `validate tournament winner is actually one of the players`() {
        val tournament = Tournament(getPlayers(12))

        val winner = tournament.winner

        assertEquals(winner, tournament.winner)
        assertTrue(tournament.registeredPlayers.contains(winner))
    }

    @Test
    fun `validate big tournament winner is actually one of the players`() {
        val tournament = Tournament(getPlayers(70))

        val winner = tournament.winner

        assertEquals(winner, tournament.winner)
        assertTrue(tournament.registeredPlayers.contains(winner))
    }


    private fun getPlayers(participantsAmount: Int): List<Player>{
        val players = ArrayList<Player>()
        for (i in  1..participantsAmount) {
            players.add(Player("Player $i", Random.nextInt(1, 100)))
        }
        return players
    }
}