package net.rossmanges.aoc

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day2Kotest : FunSpec ({
    val miniInput = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2"
    )

    test("partOneMiniInput") {
        productOfPositionAndDepth(miniInput).shouldBe(150)
    }

    test("partTwoMiniInput") {
        productOfPositionAndDepthWithAim(miniInput).shouldBe(900)
    }
})