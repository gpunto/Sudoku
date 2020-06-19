package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Coordinate
import com.gianmarcodavid.sudoku.Subject

internal class Slice(size: Int, coordinate: (Int) -> Coordinate) : Subject {
    override val coordinates: List<Coordinate> = List(size, coordinate)
}