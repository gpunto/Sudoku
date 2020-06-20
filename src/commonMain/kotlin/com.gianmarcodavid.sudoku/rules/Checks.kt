package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Check
import com.gianmarcodavid.sudoku.Coordinate
import com.gianmarcodavid.sudoku.Rule
import com.gianmarcodavid.sudoku.Subject

fun and(vararg operands: Check): Check = And(operands.toList())
