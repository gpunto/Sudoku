package com.gianmarcodavid.sudoku

class Rule<T>(val subjects: List<Subject>, val check: Check<T>)

data class Subject(val coordinates: List<Coordinate>)

typealias Check<T> = (cellGroup: List<Pair<Coordinate, Cell<T>>>) -> Boolean

data class Coordinate(val row: Int, val col: Int)