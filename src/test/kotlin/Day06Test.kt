import answer.Answer
import answer.answerEquals
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
    answerEquals(Answer.DAY06_PART1, Day06.part1(getResourceAsString("day06.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(4, Day06.part2(getResourceAsString("day06-sample.txt")))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY06_PART2, Day06.part2(getResourceAsString("day06.txt")))
  }

}