package com.gianmarcodavid.sudoku

class Rule(val subjects: List<Subject>, val check: Check)

interface Subject {
    val coordinates: List<Coordinate>
}

interface Check {
    fun check(cellGroup: List<Pair<Coordinate, Cell>>): Boolean
}

data class Coordinate(val row: Int, val col: Int)