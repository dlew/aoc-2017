import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day21Test {

  @Test
  fun part1sample() {
    assertEquals(12, Day21.solve(getResourceAsString("day21-sample.txt"), 2))
  }

  @Test
  fun part1() {
    assertEquals(117, Day21.solve(getResourceAsString("day21.txt"), 5))
  }

  @Test
  fun part2() {
    assertEquals(2026963, Day21.solve(getResourceAsString("day21.txt"), 18))
  }

}