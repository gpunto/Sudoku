package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Cell
import com.gianmarcodavid.sudoku.Check
import com.gianmarcodavid.sudoku.Coordinate

internal class And(private val operands: Iterable<Check>) : Check {
    override fun check(cellGroup: List<Pair<Coordinate, Cell>>): Boolean =
        operands.all { it.check(cellGroup) }
}