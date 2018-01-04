import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day05Test {

  @Test
  fun part1sample() {
    assertEquals(5, Day05.part1(getResourceAsString("day05-sample.txt")))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY05_PART1, Day05.part1(getResourceAsString("day05.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(10, Day05.part2(getResourceAsString("day05-sample.txt")))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY05_PART2, Day05.part2(getResourceAsString("day05.txt")))
  }

}