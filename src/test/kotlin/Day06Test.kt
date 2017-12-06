import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day06Test {

  @Test
  fun part1sample() {
    assertEquals(5, Day06.part1(getResourceAsString("day06-sample.txt")))
  }

  @Test
  fun part1() {
    assertEquals(3156, Day06.part1(getResourceAsString("day06.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(4, Day06.part2(getResourceAsString("day06-sample.txt")))
  }

  @Test
  fun part2() {
    assertEquals(1610, Day06.part2(getResourceAsString("day06.txt")))
  }

}