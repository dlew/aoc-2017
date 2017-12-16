import answer.Answer
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day24Test {

  @Test
  fun part1sample() {
    assertEquals(31, Day24.part1(getResourceAsString("day24-sample.txt")))
  }

  @Test
  fun part1() {
    assertEquals(Answer.DAY24_PART1, Day24.part1(getResourceAsString("day24.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(19, Day24.part2(getResourceAsString("day24-sample.txt")))
  }

  @Test
  fun part2() {
    assertEquals(Answer.DAY24_PART2, Day24.part2(getResourceAsString("day24.txt")))
  }

}