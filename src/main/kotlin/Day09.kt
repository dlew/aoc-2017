object Day09 {

  fun part1(input: String): Int {
    return parseInput(input).score
  }

  fun part2(input: String): Int {
    return parseInput(input).garbageCount
  }

  private fun parseInput(input: String): Info {
    var groupLevel = 0
    var inGarbage = false
    var ignoreNext = false
    var score = 0
    var garbageCount = 0
    for (token in input) {
      if (!inGarbage) {
        when (token) {
          '{' -> groupLevel++
          '}' -> {
            score += groupLevel
            groupLevel--
          }
          '<' -> inGarbage = true
        }
      } else if (ignoreNext) {
        ignoreNext = false
      } else {
        when (token) {
          '>' -> inGarbage = false
          '!' -> ignoreNext = true
          else -> garbageCount++
        }
      }
    }

    return Info(score, garbageCount)
  }

  data class Info(val score: Int, val garbageCount: Int)

}