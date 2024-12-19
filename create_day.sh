#!/bin/bash

# Get the current year and day, with optional override for the day
YEAR=$(date +%Y) # Get the current year
DAY=$(date +%d)  # Default to today's day number
if [ $# -eq 1 ]; then
    DAY=$1
fi

# Pad the day number to two digits only if it's a single digit
if [ ${#DAY} -eq 1 ]; then
    DAY_PADDED="0$DAY"
else
    DAY_PADDED="$DAY"
fi

# Define the folder and file paths
FOLDER="src/$YEAR/Day$DAY_PADDED"
KT_FILE="$FOLDER/Day$DAY_PADDED.kt"
TEST_FILE="$FOLDER/Day$DAY_PADDED""_test.txt"
INPUT_FILE="$FOLDER/Day$DAY_PADDED.txt"

# Create the directory
mkdir -p "$FOLDER"

# Populate the Kotlin file
cat <<EOL > "$KT_FILE"
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the \`src/$YEAR/Day${DAY_PADDED}/Day${DAY_PADDED}_test.txt\` file:
    val testInput = readInput("$YEAR/Day${DAY_PADDED}/Day${DAY_PADDED}_test")
    check(part1(testInput) == 1)

    // Read the input from the \`src/$YEAR/Day${DAY_PADDED}/Day${DAY_PADDED}.txt\` file.
    val input = readInput("$YEAR/Day${DAY_PADDED}/Day${DAY_PADDED}")
    part1(input).println()
    part2(input).println()
}
EOL

# Create the test and input files
touch "$TEST_FILE"
touch "$INPUT_FILE"

# Confirmation message
echo "Folder and files for Day $DAY_PADDED in year $YEAR have been created:"
echo " - $KT_FILE"
echo " - $TEST_FILE"
echo " - $INPUT_FILE"
