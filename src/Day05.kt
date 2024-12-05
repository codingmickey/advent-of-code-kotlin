
const val DAY = "05"

fun main() {

    fun doesExist(
        toChecks: MutableSet<Int>,
        rules: MutableMap<Int, MutableSet<Int>>,
        el: Int
    ): Boolean {
        for (toCheck in toChecks) {
            if (rules[el]?.contains(toCheck) == true) {
                return true
            }
        }
        return false
    }

    fun checkExists(
        update: List<Int>,
        rules: MutableMap<Int, MutableSet<Int>>
    ): Boolean {
        val toChecks = mutableSetOf<Int>()
        var exists = false
        for (el in update) {
            // To check in the set of the element if any element is in this set
            if (doesExist(toChecks, rules, el)) {
                exists = true
                break
            }
            toChecks.add(el)
        }
        return exists
    }


    fun part1(input: List<String>): Int {
        val ans = mutableListOf<List<Int>>()

        val rules: MutableMap<Int, MutableSet<Int>> = mutableMapOf()

        val findSpace = input.indexOf("")

        val unparsedRules = input.subList(0, findSpace)

        val updates = input.subList(findSpace+1, input.size)

        println("unparsedRules $unparsedRules, updates $updates")

        unparsedRules.forEach { rule ->
            val ints = rule.split("|").map { it.toInt() }
            if (rules.containsKey(ints[0])) {
                rules[ints[0]]?.add(ints[1])
            } else {
                rules[ints[0]] = mutableSetOf(ints[1])
            }
        }

        rules.println()

        val updatesList = updates.map { update -> update.split(',').map { it.toInt() } }


        for (update in updatesList) {
            val toChecks = mutableSetOf<Int>()
            var exists = false
            for (el in update) {
// To check in the set of the element if any element is in this set
                if (doesExist(toChecks, rules, el)) {
                    exists = true
                    break
                }
                toChecks.add(el)
            }
            if (!exists) ans.add(update)
        }
        ans.println()

        val finalAns = ans.map { it[it.size / 2] }.reduce { acc, i -> acc + i }

        finalAns.println()
        return finalAns
    }


    fun part2(input: List<String>): Int {
        val ans = mutableListOf<List<Int>>()

        val rules: MutableMap<Int, MutableSet<Int>> = mutableMapOf()

        val findSpace = input.indexOf("")

        val unparsedRules = input.subList(0, findSpace)

        val updates = input.subList(findSpace+1, input.size)

        println("unparsedRules $unparsedRules, updates $updates")

        unparsedRules.forEach { rule ->
            val ints = rule.split("|").map { it.toInt() }
            if (rules.containsKey(ints[0])) {
                rules[ints[0]]?.add(ints[1])
            } else {
                rules[ints[0]] = mutableSetOf(ints[1])
            }
        }

        rules.println()

        val updatesList = updates.map { update -> update.split(',').map { it.toInt() } }


        for (update in updatesList) {
            val exists = checkExists(update, rules)
            if (!exists) continue

            val sortedWith = update.sortedWith { o1, o2 ->
                when (rules[o1]?.contains(o2)) {
                    true -> 1
                    else -> -1
                }
            }
            sortedWith.println()
            ans.add(sortedWith)
        }
        ans.println()

        val finalAns = ans.map { it[it.size / 2] }.reduce { acc, i -> acc + i }

        return finalAns
    }


    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 10)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput) == 143)
    check(part2(testInput) == 123)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day${DAY}")
    part1(input).println()
    part2(input).println()
}
