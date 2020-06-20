package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Coordinate
import com.gianmarcodavid.sudoku.Fixed
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

internal class UniqueTest : StringSpec({

    "true if all unique" {
        checkAll { ns: List<Int> ->
            val group = ns.map { Coordinate(0, 0) to Fixed(it) }

            unique(group) shouldBe (ns.size == ns.distinct().size)
        }
    }

})