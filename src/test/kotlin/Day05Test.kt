import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day05Test {

  @Test
  fun part1sample() {
    assertEquals(5, Day05.stepsToEscape(getResourceAsString("day05-sample.txt"), false))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY05_PART1, Day05.stepsToEscape(getResourceAsString("day05.txt"), false))
  }

  @Test
  fun part2sample() {
    assertEquals(10, Day05.stepsToEscape(getResourceAsString("day05-sample.txt"), true))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY05_PART2, Day05.stepsToEscape(getResourceAsString("day05.txt"), true))
  }

}