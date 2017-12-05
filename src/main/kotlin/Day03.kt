import grid.Direction
import grid.Point
import kotlin.coroutines.experimental.buildSequence
import kotlin.math.abs

object Day03 {

  fun part1(input: Int): Int {
    // Special case
    if (input == 1) {
      return 1
    }

    val coordinates = generateSpiralSequence().take(input).last()
    return abs(coordinates.x) + abs(coordinates.y)
  }

  fun part2(input: Int): Int {
    val grid = mutableMapOf<Point, Int>()
    grid[Point(0, 0)] = 1

    generateSpiralSequence().drop(1).forEach { coordinates ->
      val gridValue = gridValue(grid, coordinates.x, coordinates.y)
      grid[coordinates] = gridValue

      if (gridValue > input) {
        return gridValue
      }
    }

    throw IllegalStateException("How did you get here?!")
  }

  private fun gridValue(grid: Map<Point, Int>, x: Int, y: Int): Int {
    var count = 0
    for (dx in -1..1) {
      for (dy in -1..1) {
        if (dx == 0 && dy == 0) {
          continue
        }

        count += grid[Point(x + dx, y + dy)] ?: 0
      }
    }

    return count
  }

  private fun generateSpiralSequence(): Sequence<Point> {
    return buildSequence {
      var point = Point(0, 0)
      var maxX = 0
      var minX = 0
      var maxY = 0
      var minY = 0
      var direction = Direction.EAST

      yield(point)

      while (true) {
        when (direction) {
          Direction.EAST -> {
            maxX += 1
            while (point.x != maxX) {
              point = point.move(Direction.EAST)
              yield(point)
            }
            direction = Direction.NORTH
          }
          Direction.NORTH -> {
            minY -= 1
            while (point.y != minY) {
              point = point.move(Direction.NORTH)
              yield(point)
            }
            direction = Direction.WEST
          }
          Direction.WEST -> {
            minX -= 1
            while (point.x != minX) {
              point = point.move(Direction.WEST)
              yield(point)
            }
            direction = Direction.SOUTH
          }
          Direction.SOUTH -> {
            maxY += 1
            while (point.y != maxY) {
              point = point.move(Direction.SOUTH)
              yield(point)
            }
            direction = Direction.EAST
          }
        }
      }
    }
  }


}