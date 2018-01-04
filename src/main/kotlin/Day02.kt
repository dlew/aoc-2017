import utils.splitNewlines
import utils.splitWhitespace
import utils.toIntList

object Day02 {

  fun part1(input: String): Int {
    return input.splitNewlines().sumBy {
      val values = it.splitWhitespace().toIntList()
      var min = values.minBy { it }!!
      var max = values.maxBy { it }!!
      max - min
    }
  }

  fun part2(input: String): Int {
    return input.splitNewlines().sumBy {
      val values = it.splitWhitespace().toIntList()
      for (a in 0 until values.size) {
        for (b in a + 1 until values.size) {
          val one = values[a]
          val two = values[b]
          if (one % two == 0) {
            return@sumBy one / two
          } else if (two % one == 0) {
            return@sumBy two / one
          }
        }
      }

      throw IllegalArgumentException("Should not happen!")
    }
  }
}