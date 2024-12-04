fun main() {
    val xmas = "XMAS"
    val samx = "SAMX"
    val mas = "MAS"
    val sam = "SAM"
    fun checkValid(input: String): Int {
        var count = 0
        var i = 0
        while (i < input.length - 3) {
            val toCheck = input.substring(i, i + 4)
            toCheck.println()
            if (toCheck == xmas || toCheck == samx) {
                count++
                i += 3
            } else i++
        }
        return count
    }

    fun convertToLinear(input: List<String>): List<String> {
        val m = input.size
        val n = input[0].length

        val lists = mutableListOf<String>()
        for (j in input.indices) {
            var i = 0
            var k = j
            var temp = ""
            while (i < n && k < m) {
                temp += input[k][i]
                i++
                k++
            }
            temp.println()
            lists.add(temp)
        }
        lists.println()
        for (j in 1..<n) {
            var i = j
            var k = 0
            var temp = ""
            while (i < n && k < m) {
                temp += input[k][i]
                i++
                k++
            }
            temp.println()
            lists.add(temp)
        }
        lists.println()
        return lists
    }


    fun part1(input: List<String>): Int {
        var ans = 0
        val anotherInput = ",".repeat(input.size - 1).split(",").toMutableList()
        for (i in input.indices) {
            for (j in input[0].indices) {
                anotherInput[j] = anotherInput[j] + input[i][j]
            }
        }

        val diagonalInputTB = convertToLinear(input)
        val diagonalInputBT = convertToLinear(input.reversed())

        for (str in diagonalInputTB) ans += checkValid(str)
        for (str in diagonalInputBT) ans += checkValid(str)
        for (str in input) ans += checkValid(str)
        for (str in anotherInput) ans += checkValid(str)

        println("This is the ans $ans")

        input.println()
        anotherInput.println()
        return ans
    }

    fun part2(input: List<String>): Int {
        val n = input.size
        val m = input.first().length
        var ans = 0

        for (i in input.indices) {
            for (j in input[0].indices) {
                if (i + 1 < n && j + 1 < m && input[i + 1][j + 1] == 'A') {
                    if (i + 2 < n && j + 2 < m) {
                        val diagonal1 = "${input[i][j]}${input[i + 1][j + 1]}${input[i + 2][j + 2]}"
                        val diagonal2 = "${input[i + 2][j]}${input[i + 1][j + 1]}${input[i][j + 2]}"

                        if ((diagonal1 == mas || diagonal1 == sam) && (diagonal2 == mas || diagonal2 == sam)) {
                            ans++
                        }
                    }
                }
            }
        }
        println("This is the ans $ans")
        return ans
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 10)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day04_test")
    check(part2(testInput) == 9)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
