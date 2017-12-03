import kotlin.math.abs

object Day03 {

  private enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }

  data class Coordinates(val x: Int, val y: Int)

  fun part1(input: Int): Int {
    // Special case
    if (input == 1) {
      return 1
    }

    val coordinates = findCoordinates(input)
    return abs(coordinates.x) + abs(coordinates.y)
  }

  private fun findCoordinates(square: Int): Coordinates {
    var x = 0
    var y = 0
    var maxX = 0
    var minX = 0
    var maxY = 0
    var minY = 0
    var nextDirection = Direction.RIGHT
    var count = 1

    while (true) {
      when (nextDirection) {
        Direction.RIGHT -> {
          maxX += 1
          val distance = abs(maxX - x)
          x = maxX

          if (count + distance >= square) {
            return Coordinates(x + (square - count - distance), y)
          }

          count += distance
          nextDirection = Direction.UP
        }
        Direction.UP -> {
          minY -= 1
          val distance = abs(minY - y)
          y = minY

          if (count + distance > square) {
            return Coordinates(x, y - (square - count - distance))
          }

          count += distance
          nextDirection = Direction.LEFT
        }
        Direction.LEFT -> {
          minX -= 1
          val distance = abs(minX - x)
          x = minX

          if (count + distance > square) {
            return Coordinates(x - (square - count - distance), y)
          }

          count += distance

          nextDirection = Direction.DOWN
        }
        Direction.DOWN -> {
          maxY += 1
          val distance = abs(maxY - y)
          y = maxY

          if (count + distance > square) {
            return Coordinates(x, y + (square - count - distance))
          }

          count += distance
          nextDirection = Direction.RIGHT
        }
      }
    }
  }

  fun part2(input: Int): Int {
    val grid = mutableMapOf<Coordinates, Int>()
    grid[Coordinates(0, 0)] = 1

    var x = 0
    var y = 0
    var maxX = 0
    var minX = 0
    var maxY = 0
    var minY = 0
    var nextDirection = Direction.RIGHT

    while(true) {
      when (nextDirection) {
        Direction.RIGHT -> {
          maxX += 1

          for (a in x until maxX) {
            x += 1
            val gridValue = gridValue(grid, x, y)
            grid[Coordinates(x, y)] = gridValue

            if (gridValue > input) {
              return gridValue
            }
          }
          x = maxX

          nextDirection = Direction.UP
        }
        Direction.UP -> {
          minY -= 1

          for (a in y downTo minY + 1){
            y -= 1
            val gridValue = gridValue(grid, x, y)
            grid[Coordinates(x, y)] = gridValue

            if (gridValue > input) {
              return gridValue
            }
          }
          y = minY

          nextDirection = Direction.LEFT
        }
        Direction.LEFT -> {
          minX -= 1

          for (a in x downTo minX + 1){
            x -= 1
            val gridValue = gridValue(grid, x, y)
            grid[Coordinates(x, y)] = gridValue

            if (gridValue > input) {
              return gridValue
            }
          }

          x = minX

          nextDirection = Direction.DOWN
        }
        Direction.DOWN -> {
          maxY += 1

          for (a in y until maxY) {
            y += 1
            val gridValue = gridValue(grid, x, y)
            grid[Coordinates(x, y)] = gridValue

            if (gridValue > input) {
              return gridValue
            }
          }

          y = maxY

          nextDirection = Direction.RIGHT
        }
      }
    }
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

}