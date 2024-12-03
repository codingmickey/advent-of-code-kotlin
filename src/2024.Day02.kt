import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

//    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")

    var lists: MutableList<List<Int>> = mutableListOf()
    testInput.map { s -> lists.add(s.split(" ").map { it.toInt() }) }
    lists.println()
    var ans = 0

    for (i in 0 until lists.size) {


        if (checkIncreasing(lists[i])  || checkDecreasing(lists[i])) {
            ans+=1
            ans.println()
            lists[i].println()
            continue
        }
        // Iterate through each element, remove it, and check
        for (j in lists[i].indices) {
            val modifiedList = lists[i].filterIndexed { index, _ -> index != j } // Remove the j-th element
            if (checkIncreasing(modifiedList)  || checkDecreasing(modifiedList)) {
                ans += 1
                println("Modified list is valid after removing index $j: $modifiedList")
                break
            }
        }

    }

    ans.println()


    check(part1(testInput) == 1000)
//
//    // Read the input from the `src/Day01.txt` file.
//    val input = readInput("Day01")
//    part1(input).println()
//    part2(input).println()
}

fun checkIncreasing(list: List<Int>): Boolean {
    var count = 0
    for (i in 1 until list.size) {
        if (list[i] <= list[i - 1] || levelDiff(list, i)) return false
        println("inc$list, $count")
    }
    return true
}

private fun levelDiff(list: List<Int>, i: Int) = (list[i] - list[i - 1]).absoluteValue > 3

fun checkDecreasing(list: List<Int>): Boolean {
    var count = 0
    for (i in 1 until list.size) {
        if (list[i] >= list[i - 1] || levelDiff(list, i)) return false
        println("dec$list, $count")
    }
    return true
}

fun removeLevel(list: List<Int>) {
    var count = 0
    for (i in 1 until list.size) {
        if (list[i] >= list[i - 1] || levelDiff(list, i)) count++
    }


}