package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Cell
import com.gianmarcodavid.sudoku.Check
import com.gianmarcodavid.sudoku.Coordinate
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

internal class AndTest : StringSpec({

    "true if all return true" {
        checkAll { bs: List<Boolean> ->
            val checks = bs.map { b ->
                object : Check {
                    override fun check(cellGroup: List<Pair<Coordinate, Cell>>) = b
                }
            }

            And(checks).check(emptyList()) shouldBe bs.all { it }
        }
    }
})