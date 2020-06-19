package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Coordinate
import com.gianmarcodavid.sudoku.Fixed
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

internal class InRangeTest {

    @Test
    fun `when all in range, return true`() {
        val check = InRange(1..5)

        assertTrue(check.check(fixedCoordinatePairsOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `when one out of range, return false`() {
        val check = InRange(1..7)

        assertFalse(check.check(fixedCoordinatePairsOf(0, 1, 5, 7)))
        assertFalse(check.check(fixedCoordinatePairsOf(2, 4, 6, 8)))
    }

    private fun fixedCoordinatePairsOf(vararg ns: Int) =
        ns.map { Coordinate(0, 0) to Fixed(it) }
}