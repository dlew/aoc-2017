package grid

enum class Direction {
  NORTH,
  EAST,
  SOUTH,
  WEST;

  fun turn(turn: Turn) =
      when(turn) {
        Turn.NONE -> this
        Turn.LEFT -> when (this) {
          NORTH -> WEST
          WEST -> SOUTH
          SOUTH -> EAST
          EAST -> NORTH
        }
        Turn.RIGHT -> when (this) {
          NORTH -> EAST
          EAST -> SOUTH
          SOUTH -> WEST
          WEST -> NORTH
        }
      }
}