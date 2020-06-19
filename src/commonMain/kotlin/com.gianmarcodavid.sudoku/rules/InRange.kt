package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.*

internal class InRange(private val range: IntRange) : Check {
    override fun check(cellGroup: List<Pair<Coordinate, Cell>>): Boolean =
        cellGroup.all { (_, cell) ->
            when (cell) {
                is Fixed -> cell.n in range
                is Open -> true
            }
        }
}