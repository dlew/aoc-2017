object Day17 {

  fun part1(steps: Int): Int {
    val buffer = mutableListOf(0)
    var index = 0
    for (insert in 1..2017) {
      index = 1 + (index + steps) % buffer.size
      buffer.add(index, insert)
    }
    return buffer[(index + 1) % buffer.size]
  }

  fun part2(steps: Int): Int {
    var lastInterestingInsert = 0
    var index = 0
    for (size in 1..50000000) {
      index = 1 + (index + steps) % size
      if (index == 1) {
        lastInterestingInsert = size
      }
    }
    return lastInterestingInsert
  }

}