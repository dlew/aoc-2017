import utils.splitNewlines
import grid.Direction
import grid.Point
import grid.Turn

object Day19 {

  fun part1(input: String): String {
    return travel(input).letters
  }

  fun part2(input: String): Int {
    return travel(input).steps
  }

  private fun travel(input: String): Data {
    val grid: List<CharArray> = input.split("\n").map { it.toCharArray() }

    // Find the starting point
    var point = Point(grid[0].indexOf('|'), 0)
    var direction = Direction.SOUTH

    var letters = ""
    var steps = 0
    while (grid.charAt(point) != ' ') {
      val char = grid.charAt(point)
      when (char) {
        in 'A'..'Z' -> letters += char
        '+' -> {
          if (grid.charAt(point.move(direction.turn(Turn.LEFT))) != ' ') {
            direction = direction.turn(Turn.LEFT)
          }
          else {
            direction = direction.turn(Turn.RIGHT)
          }
        }
      }

      steps++
      point = point.move(direction)
    }

    return Data(letters, steps)
  }

  class Data(val letters: String, val steps: Int)

  private fun List<CharArray>.charAt(point: Point) = this[point.y][point.x]

}