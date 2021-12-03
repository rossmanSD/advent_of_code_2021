package net.rossmanges.aoc

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day3Kotest : FunSpec( {
    val miniInput = listOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010"
    )

    test("partOneMiniInput") {
        powerConsumption(miniInput).shouldBe(198)
    }

    test ("partTwoMiniInput") {
        oxygenRating(miniInput).shouldBe(23)
        co2ScrubberRating(miniInput).shouldBe(10)
        lifeSupportRating(miniInput).shouldBe(230)
    }
})