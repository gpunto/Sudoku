package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Coordinate
import com.gianmarcodavid.sudoku.Fixed
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

internal class InRangeTest : StringSpec({

    "true if all in range" {
        checkAll { ns: List<Int>, rangeStart: Int, rangeEnd: Int ->
            val group = ns.map { Coordinate(0, 0) to Fixed(it) }
            val range = rangeStart..rangeEnd

            inRange(range)(group) shouldBe ns.all(range::contains)
        }
    }
})