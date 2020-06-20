package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Coordinate
import com.gianmarcodavid.sudoku.Subject

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
