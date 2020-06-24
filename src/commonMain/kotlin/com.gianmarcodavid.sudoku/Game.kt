package com.gianmarcodavid.sudoku

data class Game<T>(val board: Board<T>, val rules: List<Rule<T>>)

