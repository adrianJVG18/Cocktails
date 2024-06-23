package com.adrian.cocktails.commons.ext

fun <D> List<D>.groupInPairs(): List<Pair<D, D?>> {
    val result = mutableListOf<Pair<D, D?>>()

    for (i in this.indices step 2) {
        val firstElement = this[i]
        val secondElement = if (i + 1 < this.size) this[i + 1] else null
        result.add(Pair(firstElement, secondElement))
    }
    return result
}