import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitNewlines
import utils.toIntList

class Day13Test {

  @Test
  fun part1sample() {
    assertEquals(24, Day13.part1(getResourceAsString("day13-sample.txt")))
  }

  @Test
  fun part1() {
    assertEquals(2160, Day13.part1(getResourceAsString("day13.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(10, Day13.part2(getResourceAsString("day13-sample.txt")))
  }

  @Test
  fun part2() {
    assertEquals(3907470, Day13.part2(getResourceAsString("day13.txt")))
  }

}