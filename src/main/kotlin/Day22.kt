import grid.Direction
import grid.Point
import grid.Turn
import utils.splitNewlines

object Day22 {

  fun part1(input: String, iterations: Int): Int {
    val midpoint = (input.splitNewlines().size / 2)
    val infections = parse(input).toMutableSet()
    var carrier = Point(midpoint, midpoint)
    var direction = Direction.NORTH
    var infectionCount = 0

    for (iteration in 0 until iterations) {
      // Step 1
      val pointInfected = carrier in infections
      val turn = if (pointInfected) Turn.RIGHT else Turn.LEFT
      direction = direction.turn(turn)

      // Step 2
      if (!pointInfected) {
        infections.add(carrier)
        infectionCount++
      } else {
        infections.remove(carrier)
      }

      // Step 3
      carrier = carrier.move(direction)
    }

    return infectionCount
  }

  fun part2(input: String, iterations: Int): Int {
    val midpoint = (input.splitNewlines().size / 2)
    val infections = parse(input).associate { it to State.INFECTED }.toMutableMap()
    var carrier = Point(midpoint, midpoint)
    var direction = Direction.NORTH
    var infectionCount = 0

    for (iteration in 0 until iterations) {
      // Step 1
      val pointState = infections[carrier] ?: State.CLEAN
      direction = when (pointState) {
        State.CLEAN -> direction.turn(Turn.LEFT)
        State.WEAKENED -> direction
        State.INFECTED -> direction.turn(Turn.RIGHT)
        State.FLAGGED -> direction.turn(Turn.LEFT).turn(Turn.LEFT)
      }

      // Step 2
      when (pointState) {
        State.CLEAN -> infections[carrier] = State.WEAKENED
        State.WEAKENED -> {
          infections[carrier] = State.INFECTED
          infectionCount++
        }
        State.INFECTED -> infections[carrier] = State.FLAGGED
        State.FLAGGED -> infections.remove(carrier)
      }

      // Step 3
      carrier = carrier.move(direction)
    }

    return infectionCount
  }

  private enum class State {
    CLEAN,
    WEAKENED,
    INFECTED,
    FLAGGED
  }

  private fun parse(input: String): Set<Point> {
    val infections = mutableSetOf<Point>()
    input.splitNewlines().forEachIndexed { y, line ->
      line.forEachIndexed { x, char ->
        if (char == '#') {
          infections.add(Point(x = x, y = y))
        }
      }
    }
    return infections
  }

}