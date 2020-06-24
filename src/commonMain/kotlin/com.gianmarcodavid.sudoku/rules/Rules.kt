package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Rule

fun sudoku(rows: Int, columns: Int): Rule<Int> {
    val side = rows * columns
    val rs = List(side) { row(it, side) }
    val cs = List(side) { column(it, side) }
    val bs = List(side) { box(it, rows, columns) }

    return Rule(
        rs + cs + bs,
        and(inRange(1..(side * side)), unique())
    )
}
