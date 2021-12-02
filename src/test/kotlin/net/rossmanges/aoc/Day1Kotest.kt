package net.rossmanges.aoc

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day1Kotest : FunSpec({
    val miniInput = listOf(
        199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263
    )

    test("testPart1MiniInput") {
        getNumOfMeasurementsLargerThanPrevious(miniInput).shouldBe(7)
    }


    test("testPart2MiniInput") {
        getSumsOptimized(miniInput).shouldBe(5)
    }
})