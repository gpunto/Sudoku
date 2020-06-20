package com.gianmarcodavid.sudoku.rules

import com.gianmarcodavid.sudoku.Check
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

internal class AndTest : StringSpec({

    "true if all return true" {
        checkAll { bs: List<Boolean> ->
            val checks = bs.map(fun(b: Boolean): Check = { b }).toTypedArray()

            and(*checks)(emptyList()) shouldBe bs.all { it }
        }
    }
})