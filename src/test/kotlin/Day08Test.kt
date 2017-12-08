import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitNewlines
import utils.splitWhitespace

class Day08Test {

  @Test
  fun part1sample() {
    assertEquals(1, Day08.part1(getResourceAsString("day08-sample.txt")))
  }

  @Test
  fun part1() {
    assertEquals(5221, Day08.part1(getResourceAsString("day08.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(10, Day08.part2(getResourceAsString("day08-sample.txt")))
  }

  @Test
  fun part2() {
    assertEquals(7491, Day08.part2(getResourceAsString("day08.txt")))
  }

}