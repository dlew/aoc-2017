import grid.Point

object Day14 {

  fun part1(input: String): Int {
    return inputToDisk(input).sumBy { row ->
      row.sumBy { if (it) 1 else 0 }
    }
  }

  fun part2(input: String): Int {
    val disk = inputToDisk(input)

    val unvisited = mutableSetOf<Point>()

    disk.forEachIndexed { row, values ->
      values.forEachIndexed { col, value ->
        if (value) {
          unvisited.add(Point(col, row))
        }
      }
    }

    var numRegions = 0
    while (unvisited.isNotEmpty()) {
      val start = unvisited.toList()[0]
      val queue = mutableListOf(start)
      val visited = mutableSetOf<Point>()

      while (queue.isNotEmpty()) {
        val point = queue.removeAt(0)

        if (point in visited) {
          continue
        }

        visited.add(point)

        if (disk[point.y][point.x]) {
          unvisited.remove(point)

          if (point.y > 0) {
            queue.add(point.copy(y = point.y - 1))
          }
          if (point.y < 127) {
            queue.add(point.copy(y = point.y + 1))
          }
          if (point.x > 0) {
            queue.add(point.copy(x = point.x - 1))
          }
          if (point.x < 127) {
            queue.add(point.copy(x = point.x + 1))
          }
        }
      }

      numRegions++
    }

    return numRegions
  }

  private fun inputToDisk(input: String): List<List<Boolean>> {
    return (0 until 128)
        .map { a ->
          val key = "$input-$a"
          val hash = Day10.part2(key)
          hash.map { hexToBinaryString(it) }.joinToString("").map { it == '1' }
        }
  }

  private fun hexToBinaryString(char: Char): String {
    return when (char) {
      '0' -> "0000"
      '1' -> "0001"
      '2' -> "0010"
      '3' -> "0011"
      '4' -> "0100"
      '5' -> "0101"
      '6' -> "0110"
      '7' -> "0111"
      '8' -> "1000"
      '9' -> "1001"
      'a' -> "1010"
      'b' -> "1011"
      'c' -> "1100"
      'd' -> "1101"
      'e' -> "1110"
      'f' -> "1111"
      else -> throw IllegalArgumentException("$char")
    }
  }
}