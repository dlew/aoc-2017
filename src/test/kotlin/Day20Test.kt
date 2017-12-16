import answer.Answer
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day20Test {

  @Test
  fun part1sample() {
    assertEquals(0, Day20.part1(getResourceAsString("day20-sample1.txt")))
  }

  @Test
  fun part1() {
    assertEquals(Answer.DAY20_PART1, Day20.part1(getResourceAsString("day20.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(1, Day20.part2(getResourceAsString("day20-sample2.txt")))
  }

  @Test
  fun part2() {
    assertEquals(Answer.DAY20_PART2, Day20.part2(getResourceAsString("day20.txt")))
  }

}