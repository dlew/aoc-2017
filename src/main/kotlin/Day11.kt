import utils.splitCommas
import kotlin.math.abs

object Day11 {

  fun part1(input: String): Int {
    return input
        .splitCommas()
        .fold(Hex(0, 0, 0), { hex, direction -> hex.move(direction) })
        .distanceFromCenter()
  }

  fun part2(input: String): Int {
    val directions = input.splitCommas()
    var hex = Hex(0, 0, 0)
    var max = 0
    for (direction in directions) {
      hex = hex.move(direction)
      max = maxOf(max, hex.distanceFromCenter())
    }
    return max
  }

  private data class Hex(val x: Int, val y: Int, val z: Int) {
    fun move(direction: String): Hex {
      return when (direction) {
        "n" -> copy(y = y + 1, z = z - 1)
        "ne" -> copy(x = x + 1, z = z - 1)
        "se" -> copy(x = x + 1, y = y - 1)
        "s" -> copy(y = y - 1, z = z + 1)
        "sw" -> copy(x = x - 1, z = z + 1)
        "nw" -> copy(x = x - 1, y = y + 1)
        else -> throw IllegalArgumentException("Unknown direction $direction")
      }
    }

    fun distanceFromCenter(): Int {
      return (abs(x) + abs(y) + abs(z)) / 2
    }
  }

}