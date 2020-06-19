package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.*
import kotlin.math.floor
import kotlin.math.sqrt

fun sudoku(size: Int): Rule {
    val sqrt = sqrt(size.toDouble())
    require(sqrt == floor(sqrt))
    val squareSide = sqrt.toInt()

    val rows = List(size) { row(it, size) }
    val columns = List(size) { column(it, size) }
    val squares = List(size) { square(it, squareSide) }

    println(squares.forEach { it.coordinates.map { "(${it.row},${it.col}" } })
    return Rule(
        rows + columns + squares,
        and(InRange(1..size), Unique())
    )
}

fun and(vararg operands: Check): Check = And(operands.toList())

fun row(index: Int, size: Int): Subject = Slice(size) { Coordinate(index, it) }

fun column(index: Int, size: Int): Subject = Slice(size) { Coordinate(it, index) }

fun square(index: Int, side: Int): Subject {
    val rstart = index / side * side
    val cstart = index % side * side
    return Slice(side * side) {
        Coordinate(rstart + it / side, cstart + it % side)
    }
}