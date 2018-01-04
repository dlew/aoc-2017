import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitNewlines
import utils.splitWhitespace

class Day23Test {

  @Test
  fun part1() {
    assertEquals(8281L, Day23.part1(getResourceAsString("day23.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(1, Day23.part2(getResourceAsString("day23.txt"), 0))
  }

  @Test
  fun part2() {
    assertEquals(911, Day23.part2(getResourceAsString("day23.txt"), 1))
  }

}