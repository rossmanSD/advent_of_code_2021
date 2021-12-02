package net.rossmanges.aoc

/**
 * [Advent of Code 2021: Day 2](https://adventofcode.com/2021/day/2)
 */
fun main() {
    println(
        "part 1: " +
                productOfPositionAndDepth(
                    readInput("day2-input")
                )
    )

    println(
        "part 2: " +
                productOfPositionAndDepthWithAim(
                    readInput("day2-input")
                )
    )

}

/**
 * Part 2
 */
fun productOfPositionAndDepthWithAim(input: List<String>): Int {
    // split command from value (we know input is structured this way)
    val commands = input.map { it.split(" ") }

    var forwardPosition = 0
    var depth = 0
    var aim = 0

    commands.forEach { command ->
        val value = command[1].toInt()
        when (command[0]) {
            "forward" -> {
                forwardPosition += value
                depth += aim * value
            }
            "down" -> aim += value
            "up" -> aim -= value
        }
    }
    return forwardPosition * depth
}


/**
 * Part 1
 */
fun productOfPositionAndDepth(input: List<String>): Int {
    // split command from value (we know input is structured this way)
    val commands = input.map { it.split(" ") }

    var forwardPosition = 0
    var depth = 0

    commands.forEach { command ->
        val value = command[1].toInt()
        when (command[0]) {
            "forward" -> forwardPosition += value
            "down" -> depth += value
            "up" -> depth -= value
        }
    }
    return forwardPosition * depth
}
