import answer.Answer
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
    assertEquals(Answer.DAY21_PART1, Day21.solve(getResourceAsString("day21.txt"), 5))
  }

  @Test
  fun part2() {
    assertEquals(Answer.DAY21_PART2, Day21.solve(getResourceAsString("day21.txt"), 18))
  }

}