package net.rossmanges.aoc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test {

    private val miniInput = listOf(
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

    @Test
    fun testPart1MiniInput() {
        Assertions.assertEquals(
            7, getNumOfMeasurementsLargerThanPrevious(miniInput)
        )
    }

    @Test
    fun testPart2MiniInput() {
        Assertions.assertEquals(5, getSumsOptimized(miniInput))
    }
}