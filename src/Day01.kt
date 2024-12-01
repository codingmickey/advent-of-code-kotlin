import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1000)

    val list1: MutableList<Int> = mutableListOf();
    val list2: MutableList<Int> = mutableListOf()

    testInput.println()
    testInput.forEach { s ->
        val numbers = s.split("\\s+".toRegex()).map { it.toInt() }
        list1.add(numbers[0])
        list2.add(numbers[1])

    }

    list1.println()
    list2.println()

    val sortedList1 = list1.sortedBy { it }

    val sortedList2 = list2.sortedBy { it }

    sortedList1.println()
    sortedList2.println()

    var ans = 0
    for (i in 0 until list1.size) {
//    ans.println()
        ans += abs(sortedList1[i] - sortedList2[i])
    }
    println("This is the answer answer: $ans")
//    // Read the input from the `src/Day01.txt` file.
//    val input = readInput("Day01")
//    part1(input).println()
//    part2(input).println()

    val testInput2 = readInput("Day01_test")
    check(part1(testInput2) == 1000)

    val list21: MutableList<Int> = mutableListOf();
    val list22: MutableList<Int> = mutableListOf()

    testInput2.println()
    testInput2.forEach { s ->
        val numbers = s.split("\\s+".toRegex()).map { it.toInt() }
        list21.add(numbers[0])
        list22.add(numbers[1])

    }

    val listMap = list22.groupingBy { it }.eachCount()
    listMap.println()
    list21.println()
    list22.println()

    var ans2 = 0

    for(i in 0 until list21.size) {
        ans2 += list21[i]*listMap.getOrDefault(list21[i], 0)
    }

    println("This is the answer: $ans2")
}
