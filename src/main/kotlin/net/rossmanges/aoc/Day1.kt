package net.rossmanges.aoc

/**
 * [Advent of Code 2021: Day 1](https://adventofcode.com/2021/day/1)
 */
fun main() {
    println("part 1: " +
        getNumOfMeasurementsLargerThanPrevious(
            readInput("day1-input").map { it.toInt() }
        )
    )

    println("part 2: " +
        getSumsOptimized(
            readInput("day1-input").map { it.toInt() }
        )
    )
}

/**
 * part 2 - optimized with [windowed()] and using part 1
 */
fun getSumsOptimized(measurements: List<Int>): Int {
    val sumsOfWindows = measurements.windowed(3, step = 1).map { it.sum() }
    return getNumOfMeasurementsLargerThanPrevious(sumsOfWindows)
}

/**
 * part 2 - brute force
 */
fun getNumOfSumsLargerThanPrevious(measurements: List<Int>): Int {
    var increaseCounter = 0
    for (k in 3 until measurements.size step 1) {
        val p = k-1
        val currentSum = measurements[k] + measurements[k-1] + measurements[k-2]
        val previousSum = measurements[p] + measurements[p-1] + measurements[p-2]
        val diff = currentSum - previousSum
        if (diff > 0) {
            increaseCounter++
        }
    }
    return increaseCounter
}

/**
 * part 1 - brute force
 */
fun getNumOfMeasurementsLargerThanPrevious(measurements: List<Int>): Int {
    var increaseCounter = 0
    for (i in 1 until measurements.size) {
        val previous = measurements[i - 1]
        val current = measurements[i]
        val diff = current - previous
        if (diff > 0) {
            increaseCounter++
        }
    }
    return increaseCounter
}