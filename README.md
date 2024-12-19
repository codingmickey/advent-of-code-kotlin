# advent-of-code-kotlin

Welcome to the Advent of Code[^aoc] Kotlin project created by [codingmickey][github] using the [Advent of Code Kotlin Template][template] delivered by JetBrains.

In this repository, codingmickey is about to provide solutions for the puzzles using [Kotlin][kotlin] language.

If you're stuck with Kotlin-specific questions or anything related to this template, check out the following resources:

- [Kotlin docs][docs]
- [Kotlin Slack][slack]
- Template [issue tracker][issues]

[^aoc]:
    [Advent of Code][aoc] – An annual event of Christmas-oriented programming challenges started December 2015.
    Every year since then, beginning on the first day of December, a programming puzzle is published every day for twenty-five days.
    You can solve the puzzle and provide an answer using the language of your choice.

[aoc]: https://adventofcode.com
[docs]: https://kotlinlang.org/docs/home.html
[github]: https://github.com/codingmickey
[issues]: https://github.com/kotlin-hands-on/advent-of-code-kotlin-template/issues
[kotlin]: https://kotlinlang.org
[slack]: https://surveys.jetbrains.com/s3/kotlin-slack-sign-up
[template]: https://github.com/kotlin-hands-on/advent-of-code-kotlin-template

# Create structure script

[`create_day.sh`](create_day.sh) is a script that creates a new day structure for you. It creates a new package for the day, a new Kotlin file for the day's puzzle, and a new Kotlin test file for the day's puzzle.

1. Make the script executable:

```bash
chmod +x create_day.sh
```

2. Run the script:

   - With a specific day:

   ```bash
   ./create_day.sh 1
   ```

   - Or for the current day (default):

   ```bash
   ./create_day.sh
   ```
