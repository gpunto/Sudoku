package com.gianmarcodavid.sudoku

class Rule(val subjects: List<Subject>, val check: Check)

data class Subject(val coordinates: List<Coordinate>)

typealias Check = (cellGroup: List<Pair<Coordinate, Cell>>) -> Boolean

data class Coordinate(val row: Int, val col: Int)