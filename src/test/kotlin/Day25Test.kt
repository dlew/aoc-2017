import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day25Test {

  @Test
  fun part1sample() {
    assertEquals(3, Day25.part1(getResourceAsString("day25-sample.txt")))
  }

  @Test
  fun part1() {
    assertEquals(5593, Day25.part1(getResourceAsString("day25.txt")))
  }

}