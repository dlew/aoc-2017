import kotlin.coroutines.experimental.buildSequence
import kotlin.math.abs

object Day03 {

  private enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }

  private data class Coordinates(val x: Int, val y: Int)

  fun part1(input: Int): Int {
    // Special case
    if (input == 1) {
      return 1
    }

    val coordinates = generateSpiralSequence().take(input).last()
    return abs(coordinates.x) + abs(coordinates.y)
  }

  fun part2(input: Int): Int {
    val grid = mutableMapOf<Coordinates, Int>()
    grid[Coordinates(0, 0)] = 1

    generateSpiralSequence().drop(1).forEach { coordinates ->
      val gridValue = gridValue(grid, coordinates.x, coordinates.y)
      grid[coordinates] = gridValue

      if (gridValue > input) {
        return gridValue
      }
    }

    throw IllegalStateException("How did you get here?!")
  }

  private fun gridValue(grid: Map<Coordinates, Int>, x: Int, y: Int): Int {
    var count = 0
    for (dx in -1..1) {
      for (dy in -1..1) {
        if (dx == 0 && dy == 0) {
          continue
        }

        count += grid[Coordinates(x + dx, y + dy)] ?: 0
      }
    }

    return count
  }

  private fun generateSpiralSequence(): Sequence<Coordinates> {
    return buildSequence {
      var x = 0
      var y = 0
      var maxX = 0
      var minX = 0
      var maxY = 0
      var minY = 0
      var direction = Direction.RIGHT

      yield(Coordinates(x, y))

      while (true) {
        when (direction) {
          Direction.RIGHT -> {
            maxX += 1
            while (x != maxX) {
              x += 1
              yield(Coordinates(x, y))
            }
            direction = Direction.UP
          }
          Direction.UP -> {
            minY -= 1
            while (y != minY) {
              y -= 1
              yield(Coordinates(x, y))
            }
            direction = Direction.LEFT
          }
          Direction.LEFT -> {
            minX -= 1
            while (x != minX) {
              x -= 1
              yield(Coordinates(x, y))
            }
            direction = Direction.DOWN
          }
          Direction.DOWN -> {
            maxY += 1
            while (y != maxY) {
              y += 1
              yield(Coordinates(x, y))
            }
            direction = Direction.RIGHT
          }
        }
      }
    }
  }


}