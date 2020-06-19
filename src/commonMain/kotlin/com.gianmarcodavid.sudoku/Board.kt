package com.gianmarcodavid.sudoku

data class Board(val cells: List<List<Cell>>)

sealed class Cell
data class Fixed(val n: Int) : Cell()
data class Open(val ns: List<Int>) : Cell()