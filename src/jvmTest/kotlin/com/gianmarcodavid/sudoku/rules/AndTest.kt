package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Cell
import com.gianmarcodavid.sudoku.Coordinate
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

internal class AndTest : StringSpec({

    "true if all return true" {
        checkAll { bs: List<Boolean> ->
            val checks = bs.map { b -> { _: List<Pair<Coordinate, Cell>> -> b } }.toTypedArray()

            and(*checks)(emptyList()) shouldBe bs.all { it }
        }
    }
})