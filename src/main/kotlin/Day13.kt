import utils.splitNewlines
import utils.toIntList

object Day13 {

  fun part1(input: String): Int {
    return parseInput(input).entries.sumBy { (position, range) ->
      if (safe(position, range)) 0 else position * range
    }
  }

  fun part2(input: String): Int {
    val scanners = parseInput(input)
    var delay = 0
    while (!scanners.all { (position, range) -> safe(position, range, delay) }) {
      delay++
    }
    return delay
  }

  private fun parseInput(input: String): Map<Int, Int> {
    return input.splitNewlines().associate {
      val split = it.split(": ").toIntList()
      split[0] to split[1]
    }
  }

  private fun safe(position: Int, range: Int, delay: Int = 0): Boolean {
    val time = position + delay
    val cycle = 2 + (range - 2) * 2
    return time % cycle != 0
  }

}