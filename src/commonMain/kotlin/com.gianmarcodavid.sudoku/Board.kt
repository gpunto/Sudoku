package com.gianmarcodavid.sudoku

data class Board<T>(val cells: List<List<Cell<T>>>)

sealed class Cell<T>
data class Fixed<T>(val value: T) : Cell<T>()
object Open : Cell<Nothing>()