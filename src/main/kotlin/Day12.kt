import utils.splitCommas
import utils.splitNewlines
import utils.toIntList
import java.util.regex.Pattern

object Day12 {

  fun part1(input: String): Int {
    val map = parse(input)
    return visit(map, 0).numConnected
  }

  fun part2(input: String): Int {
    val map = parse(input)
    val allIds = map.keys.toMutableSet()

    var numGroups = 0
    while (allIds.isNotEmpty()) {
      val start = allIds.toList()[0]
      val visitInfo = visit(map, start)
      allIds.removeAll(visitInfo.visited)
      numGroups++
    }

    return numGroups
  }

  private val PATTERN = Pattern.compile("(\\d+) <-> (.+)")

  private fun parse(input: String): Map<Int, Set<Int>> {
    val map = mutableMapOf<Int, MutableSet<Int>>()
    for (line in input.splitNewlines()) {
      val matcher = PATTERN.matcher(line)
      matcher.matches()
      val a = matcher.group(1).toInt()
      for (b in matcher.group(2).splitCommas().toIntList()) {
        connect(map, a, b)
        connect(map, b, a)
      }
    }
    return map
  }

  private fun connect(map: MutableMap<Int, MutableSet<Int>>, a: Int, b: Int) {
    map.getOrPut(a, { mutableSetOf() }).add(b)
  }

  private fun visit(map: Map<Int, Set<Int>>, start: Int): VisitInfo {
    var numConnected = 0
    var visited = mutableSetOf<Int>()
    var queue = mutableListOf(start)
    while (queue.isNotEmpty()) {
      val a = queue.removeAt(0)
      if (a in visited) {
        continue
      }

      numConnected++
      visited.add(a)
      queue.addAll(map[a].orEmpty())
    }
    return VisitInfo(numConnected, visited)
  }

  data class VisitInfo(val numConnected: Int, val visited: Set<Int>)

}