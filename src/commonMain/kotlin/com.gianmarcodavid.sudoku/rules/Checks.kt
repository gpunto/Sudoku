package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Check
import com.gianmarcodavid.sudoku.Fixed
import com.gianmarcodavid.sudoku.Open

fun <T> and(vararg operands: Check<T>): Check<T> = { cellGroup -> operands.all { it(cellGroup) } }

fun <T> unique(): Check<T> = { cellGroup ->
    val encountered = mutableSetOf<T>()

    cellGroup.forEach { (_, cell) ->
        (cell as? Fixed)?.value?.let {
            if (it in encountered) false
            else encountered += cell.value
        }
    }
    true
}

fun <T : Comparable<T>> inRange(range: ClosedRange<T>): Check<T> = { cellGroup ->
    cellGroup.all { (_, cell) ->
        when (cell) {
            is Fixed -> cell.value in range
            is Open -> true
        }
    }
}