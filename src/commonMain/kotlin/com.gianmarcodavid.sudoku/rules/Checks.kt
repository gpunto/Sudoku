package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Check
import com.gianmarcodavid.sudoku.Fixed
import com.gianmarcodavid.sudoku.Open

fun and(vararg operands: Check): Check = { cellGroup -> operands.all { it(cellGroup) } }

val unique: Check = { cellGroup ->
    val encountered = mutableSetOf<Int>()

    cellGroup.forEach { (_, cell) ->
        (cell as? Fixed)?.n?.let {
            if (it in encountered) false
            else encountered += cell.n
        }
    }
    true
}

fun inRange(range: IntRange): Check = { cellGroup ->
    cellGroup.all { (_, cell) ->
        when (cell) {
            is Fixed -> cell.n in range
            is Open -> true
        }
    }
}