import utils.splitNewlines
import utils.splitWhitespace

object Day04 {

  fun part1(input: String): Int {
    return input.splitNewlines().sumBy { if (valid1(it)) 1 else 0 }
  }

  private fun valid1(input: String): Boolean {
    val words = input.splitWhitespace()
    val distinctWords = words.distinct()
    return words.size == distinctWords.size
  }

  fun part2(input: String): Int {
    return input.splitNewlines().sumBy { if (valid2(it)) 1 else 0 }
  }

  private fun valid2(input: String): Boolean {
    val words = input.splitWhitespace().map { it.toCharArray().sorted().toString() }
    val distinctWords = words.distinct()
    return words.size == distinctWords.size
  }

}