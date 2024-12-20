fun main() {

    fun calculateIfPossible(
        expectedValue: Long,
        list: List<Long>,
        index: Int = 1,
        currResult: Long = list[0]
    ): Boolean {
        if (index == list.size) return currResult == expectedValue

        return calculateIfPossible(expectedValue, list, index + 1, currResult + list[index]) ||
                calculateIfPossible(expectedValue, list, index + 1, currResult * list[index])
    }

    fun calculateIfPossible2(
        expectedValue: Long,
        list: List<Long>,
        index: Int = 1,
        currResult: Long = list[0]
    ): Boolean {
        if (index == list.size) return currResult == expectedValue

        return calculateIfPossible2(expectedValue, list, index + 1, currResult + list[index]) ||
                calculateIfPossible2(expectedValue, list, index + 1, currResult * list[index]) ||
                calculateIfPossible2(
                    expectedValue,
                    list,
                    index + 1,
                    (currResult.toString() + list[index].toString()).toLong()
                )
    }


    fun part1(input: List<String>): Long {
        var total = 0L

        for (line in input) {

            val parts = line.split(":")
            val expectedValue = parts[0].toLong()
            val numList = parts[1].trim().split(' ').map { it.toLong() }
            if (calculateIfPossible(expectedValue, numList)) total += expectedValue
        }
        return total
    }

    fun part2(input: List<String>): Long {
        var total = 0L

        for (line in input) {

            val parts = line.split(":")
            parts.println()
            val expectedValue = parts[0].toLong()
            val numList = parts[1].trim().split(' ').map { it.toLong() }
            if (calculateIfPossible2(expectedValue, numList)) {

                println();expectedValue.println()
                numList.println()
                total += expectedValue
            }
        }
        total.println()
        return total
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/2024/Day07/Day07_test.txt` file:
    val testInput = readInput("2024/Day07/Day07_test")
    check(part1(testInput) == 3749L)
    check(part2(testInput) == 11387L)


    // Read the input from the `src/2024/Day07/Day07.txt` file.
    val input = readInput("2024/Day07/Day07")
    part1(input).println()
    part2(input).println()
}
