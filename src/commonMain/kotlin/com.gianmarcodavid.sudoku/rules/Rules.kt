package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Check
import com.gianmarcodavid.sudoku.Coordinate
import com.gianmarcodavid.sudoku.Rule
import com.gianmarcodavid.sudoku.Subject

fun sudoku(rows: Int, columns: Int): Rule {
    val side = rows * columns
    val rs = List(side) { row(it, side) }
    val cs = List(side) { column(it, side) }
    val bs = List(side) { box(it, rows, columns) }

    return Rule(
        rs + cs + bs,
        and(InRange(1..(side * side)), Unique())
    )
}

fun and(vararg operands: Check): Check = And(operands.toList())

fun row(index: Int, size: Int): Subject = slice(size) { Coordinate(index, it) }

fun column(index: Int, size: Int): Subject = slice(size) { Coordinate(it, index) }

fun box(index: Int, rows: Int, columns: Int): Subject {
    val rstart = index / rows * rows
    val cstart = index % rows * columns
    return slice(rows * columns) {
        Coordinate(rstart + it / columns, cstart + it % columns)
    }
}

private fun slice(size: Int, coordinate: (Int) -> Coordinate) =
    Subject(List(size, coordinate))
