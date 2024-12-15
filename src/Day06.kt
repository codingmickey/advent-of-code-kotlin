fun main() {

    fun part1(input: List<String>): Int {
        val map: MutableList<MutableList<Char>> = mutableListOf()

        var yCoordinate = 0
        var xCoordinate = 0

        for ((j, line) in input.withIndex()) {
            map.add(mutableListOf())
            for ((i, char) in line.withIndex()) {
                when (char) {
                    '^', 'v', '>', '<' -> {
                        xCoordinate = i
                        yCoordinate = j
                    }
                }
                map[j].add(char)
            }
        }
        val colS = map.size - 1
        val rowS = map.first().size - 1

        while (xCoordinate != rowS && yCoordinate != colS && xCoordinate != 0 && yCoordinate != 0) {
            when (map[yCoordinate][xCoordinate]) {
                'v' -> if (map[yCoordinate + 1][xCoordinate] != '#') {
                    map[yCoordinate][xCoordinate] = 'X'
                    yCoordinate++
                    map[yCoordinate][xCoordinate] = 'v'
                } else map[yCoordinate][xCoordinate] = '<'

                '>' -> if (map[yCoordinate][xCoordinate + 1] != '#') {
                    map[yCoordinate][xCoordinate] = 'X'
                    xCoordinate++
                    map[yCoordinate][xCoordinate] = '>'
                } else map[yCoordinate][xCoordinate] = 'v'

                '^' -> if (map[yCoordinate - 1][xCoordinate] != '#') {
                    map[yCoordinate][xCoordinate] = 'X'
                    yCoordinate--
                    map[yCoordinate][xCoordinate] = '^'
                } else map[yCoordinate][xCoordinate] = '>'

                '<' -> if (map[yCoordinate][xCoordinate - 1] != '#') {
                    map[yCoordinate][xCoordinate] = 'X'
                    xCoordinate--
                    map[yCoordinate][xCoordinate] = '<'
                } else map[yCoordinate][xCoordinate] = '^'
            }
        }

        var ans = 0
        for (row in map) {
            ans += row.count { c -> c == 'X' }
        }
        ans++

        map.println()
        xCoordinate.println()
        yCoordinate.println()
        ans.println()

        return ans
    }


    fun part2(input: List<String>): Int {
        val map: MutableList<MutableList<Char>> = mutableListOf()

        var yCoordinate = 0
        var xCoordinate = 0
        var dir = ' '

        for ((j, line) in input.withIndex()) {
            map.add(mutableListOf())
            for ((i, char) in line.withIndex()) {
                when (char) {
                    '^', 'v', '>', '<' -> {
                        xCoordinate = i
                        yCoordinate = j
                        dir = char
                    }
                }
                map[j].add(char)
            }
        }
        val colS = map.size - 1
        val rowS = map.first().size - 1

        val xCopy = xCoordinate
        val yCopy = yCoordinate

        val mapCopy = map.map { it.toMutableList() }

        while (xCoordinate != rowS && yCoordinate != colS && xCoordinate != 0 && yCoordinate != 0) {
            when (map[yCoordinate][xCoordinate]) {
                'v' -> if (map[yCoordinate + 1][xCoordinate] != '#') {
                    map[yCoordinate][xCoordinate] = 'X'
                    yCoordinate++
                    map[yCoordinate][xCoordinate] = 'v'
                } else map[yCoordinate][xCoordinate] = '<'

                '>' -> if (map[yCoordinate][xCoordinate + 1] != '#') {
                    map[yCoordinate][xCoordinate] = 'X'
                    xCoordinate++
                    map[yCoordinate][xCoordinate] = '>'
                } else map[yCoordinate][xCoordinate] = 'v'

                '^' -> if (map[yCoordinate - 1][xCoordinate] != '#') {
                    map[yCoordinate][xCoordinate] = 'X'
                    yCoordinate--
                    map[yCoordinate][xCoordinate] = '^'
                } else map[yCoordinate][xCoordinate] = '>'

                '<' -> if (map[yCoordinate][xCoordinate - 1] != '#') {
                    map[yCoordinate][xCoordinate] = 'X'
                    xCoordinate--
                    map[yCoordinate][xCoordinate] = '<'
                } else map[yCoordinate][xCoordinate] = '^'
            }
        }
        map[yCopy][xCopy] = dir
        map[yCoordinate][xCoordinate] = 'X'

        var ans = 0

        for (xIt in 0..rowS) {
            for (yIt in 0..colS) {
                if (map[yIt][xIt] == 'X') {
                    var xTemp = xCopy
                    var yTemp = yCopy
                    val mapTemp = mapCopy.map { it.toMutableList() }

                    mapTemp[yIt][xIt] = '#'

                    val seen= mutableSetOf<Pair<Pair<Int, Int>, Char>>()

                    var infiniteLoop = false

                    while (xTemp != rowS && yTemp != colS && xTemp != 0 && yTemp != 0) {
                        if(!seen.add(Pair(Pair(yTemp, xTemp), mapTemp[yTemp][xTemp]))) {
                            infiniteLoop = true
                            break
                        }

                        when (mapTemp[yTemp][xTemp]) {
                            'v' -> if (mapTemp[yTemp + 1][xTemp] != '#') {
                                mapTemp[yTemp][xTemp] = 'X'
                                yTemp++
                                mapTemp[yTemp][xTemp] = 'v'
                            } else mapTemp[yTemp][xTemp] = '<'
                            '>' -> if (mapTemp[yTemp][xTemp + 1] != '#') {
                                mapTemp[yTemp][xTemp] = 'X'
                                xTemp++
                                mapTemp[yTemp][xTemp] = '>'
                            } else mapTemp[yTemp][xTemp] = 'v'
                            '^' -> if (mapTemp[yTemp - 1][xTemp] != '#') {
                                mapTemp[yTemp][xTemp] = 'X'
                                yTemp--
                                mapTemp[yTemp][xTemp] = '^'
                            } else mapTemp[yTemp][xTemp] = '>'
                            '<' -> if (mapTemp[yTemp][xTemp - 1] != '#') {
                                mapTemp[yTemp][xTemp] = 'X'
                                xTemp--
                                mapTemp[yTemp][xTemp] = '<'
                            } else mapTemp[yTemp][xTemp] = '^'
                        }
                    }

                    if(infiniteLoop) ans++
                }
            }
        }

        map.println()
        xCoordinate.println()
        yCoordinate.println()
        ans.println()

        return ans
    }


    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 10)

    val day = "06"
    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day${day}_test")
    check(part1(testInput) == 41)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day${day}")
    part1(input).println()
    part2(input).println()
}
