package com.adrian.cocktails.miscellaneous

import androidx.annotation.VisibleForTesting
import java.util.Date
import kotlin.math.pow
import kotlin.random.Random

class Player(val name: String, val skill: Int) {
    /**
     * Obtiene el factor de suerte, el cual varia en el siguiente rango: [0.1, 1.25]
     */
    private fun getLuckFactor(): Double = Random(seed = Date().time).nextInt(10, 125)/100.0

    fun performance() = skill * getLuckFactor()
}

class Game(val a: Player, val b: Player) {

    /**
     * Con un Back field, nos aseguramos del almacenar el valor del ganador,
     * y que solo se "juegue" una vez
     */
    private var _winner: Player? = null
    val winner: Player
        get() = _winner ?: play()

    private fun play(): Player {
        val aPerformance = a.performance()
        val bPerformance = b.performance()
        _winner = when {
            // Se sigue jugando hasta que realmente se decida el ganador
            aPerformance == bPerformance -> play()
            // Se elige quien tuvo mejor desempeño
            aPerformance > bPerformance -> a
            else -> b
        }
        return _winner!!
    }

    override fun toString(): String {
        return "between ${a.name} vs. ${b.name}, the ${winner.name} is the winner"
    }
}

/**
 * La descripcion actual del torneo, busca que siempre se elimine la mitad de los participantes
 * en cada ronda. Esto no contempla los caso en el que el numero de participantes no sea potencia de 2.
 *
 * Como solucion temporal a estos casos, automaticamente son eliminados aquellos jugadores con
 * menor nivel de habilidad hasta que la lista de jugadores solo contenga una cantidad potencia de 2
 * de participantes.
 */
class Tournament(val registeredPlayers: List<Player>) {

    private var _winner: Player? = null
    val winner: Player
        get() = _winner ?: play()

    private var _players: List<Player>? = null
    @VisibleForTesting
    val players: List<Player>
        get() = _players ?: validateParticipants()


    private fun play(): Player {
        var remainingPlayers = players.toMutableList()
        val rounds = getPowerOf2(players.size)
        var currentRound = 1

        while (remainingPlayers.size > 1) {
            // "barajear" la lista
            remainingPlayers.shuffle()

            // crear lista de los que ganen la ronda actual. Como esta se "barajeo",
            // elegir de 2 en 2 ya es aleatorio
            val nextRound = mutableListOf<Player>()

            println(roundMessage(currentRound, rounds))
            // elegir de 2 en 2 jugadores para que se enfrenten
            for (i in remainingPlayers.indices step 2) {
                val game = Game(remainingPlayers[i], remainingPlayers[i + 1])
                println("$game")
                nextRound.add(game.winner)
            }
            // conservar solo los ganadores de la ronda actual
            remainingPlayers = nextRound
            currentRound++
        }
        _winner = remainingPlayers.first()
        println("$this")
        return _winner!!
    }

    @VisibleForTesting
    fun validateParticipants(): List<Player> {
        // Ordena la lista de jugadores por habilidad de mayor a menor
        registeredPlayers.sortedByDescending { it.skill }

        // Elimina los jugadores de menor habilidad hasta que la lista tenga un tamaño potencia de 2
        return registeredPlayers.dropLast(registeredPlayers.size - 2.0.pow(getPowerOf2(registeredPlayers.size)).toInt())
    }

    /**
     * Devuelve la potencia de 2 mas cercana al numero, pero no mayor que este
     */
    @VisibleForTesting
    fun getPowerOf2(number: Int): Int {
        if (number < 1)
            throw IllegalArgumentException("Number must be greater or equal than 1")

        var power = 0

        while (2.0.pow(power+1) <= number) {
            power++
        }

        return power
    }

    private fun roundMessage(round: Int, totalRound: Int): String {
        return when {
            round == totalRound -> "Final round"
            round + 1 == totalRound  -> "Semi-final round"
            round + 2 == totalRound -> "Quarter-final round"
            else -> "Round $round"
        }
    }

    override fun toString(): String {

        return "From ${registeredPlayers.size} registered players, " +
                (if (registeredPlayers.size != players.size) "only top ${players.size} players " +
                        "actually participated " else "") +
                "but the winner was ${winner.name}"
    }
}