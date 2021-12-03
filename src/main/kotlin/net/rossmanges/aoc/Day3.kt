package net.rossmanges.aoc

fun main() {
    println(
        "part 1:" +
                powerConsumption(
                    readInput("day3-input")
                )
    )

    println(
        "part 2:" +
                lifeSupportRating(
                    readInput("day3-input")
                )
    )
}

fun lifeSupportRating(input: List<String>): Int {
    return oxygenRating(input) * co2ScrubberRating(input)
}

fun oxygenRating(input: List<String>): Int {
    return filterByFunction(input, ::getMostCommonBit)
}

fun co2ScrubberRating(input: List<String>): Int {
    return filterByFunction(input, ::getLeastCommonBit)
}

fun filterByFunction(input: List<String>, function: (List<Int>) -> String): Int {
    val bitsByPosition = mutableListOf<MutableList<Int>>()
    val rowSize = input[0].length
    repeat(rowSize) {
        bitsByPosition.add(mutableListOf<Int>())
    }

    var filteredList = input
    for (i in 0 until rowSize) {
        filteredList.forEach { row ->
            val rowAsNumbers = row.map(Character::getNumericValue).toIntArray()
            bitsByPosition[i].add(rowAsNumbers[i])
        }

        val bit = function.invoke(bitsByPosition[i]).toInt(2)

        // re-filter
        filteredList = filteredList.filter { it[i].digitToInt(2) == bit }
        if (filteredList.size <=1) break
    }

    return filteredList[0].toInt(2)
}

fun powerConsumption(input: List<String>): Int {
    val bitsByPosition = mutableListOf<MutableList<Int>>()
    repeat(input[0].length) {
        bitsByPosition.add(mutableListOf<Int>())
    }

    input.forEach { row ->
        val rowAsNumbers = row.map(Character::getNumericValue).toIntArray()
        for (i in row.indices) {
            bitsByPosition[i].add(rowAsNumbers[i])
        }
    }

    var mostCommonBitsBinStr = ""
    var leastCommonBitsBinStr = ""
    for (i in bitsByPosition.indices) {
        mostCommonBitsBinStr += getMostCommonBit(bitsByPosition[i])
        leastCommonBitsBinStr += getLeastCommonBit(bitsByPosition[i])
    }

    val gammaRate = mostCommonBitsBinStr.toInt(2)
    val epsilonRate = leastCommonBitsBinStr.toInt(2)

    return gammaRate * epsilonRate
}

fun getMostCommonBit(values: List<Int>): String {
    val zero = values.count { it == 0 }
    val one = values.count { it == 1 }

    return when {
        zero > one -> "0"
        one > zero -> "1"
        else -> "1"
    }
}

fun getLeastCommonBit(values: List<Int>): String {
    val zero = values.count { it == 0 }
    val one = values.count { it == 1 }

    return when {
        zero < one -> "0"
        one < zero -> "1"
        else -> "0"
    }
}