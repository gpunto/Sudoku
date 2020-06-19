package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Cell
import com.gianmarcodavid.sudoku.Check
import com.gianmarcodavid.sudoku.Coordinate
import com.gianmarcodavid.sudoku.Fixed

internal class Unique : Check {
    override fun check(cellGroup: List<Pair<Coordinate, Cell>>): Boolean {
        val encountered = mutableSetOf<Int>()

        cellGroup.forEach { (_, cell) ->
            (cell as? Fixed)?.n?.let {
                if (it in encountered) return false
                else encountered += cell.n
            }
        }
        return true
    }
}