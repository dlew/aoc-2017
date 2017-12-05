package grid

data class Point(val x: Int, val y: Int) {

  fun move(direction: Direction): Point {
    return when(direction) {
      Direction.NORTH -> copy(y = y - 1)
      Direction.EAST -> copy(x = x + 1)
      Direction.SOUTH -> copy(y = y + 1)
      Direction.WEST -> copy(x = x - 1)
    }
  }

}