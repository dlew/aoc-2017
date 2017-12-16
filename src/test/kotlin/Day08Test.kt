import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitNewlines
import utils.splitWhitespace

class Day08Test {

  @Test
  fun part1sample() {
    assertEquals(1, Day08.part1(getResourceAsString("day08-sample.txt")))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY08_PART1, Day08.part1(getResourceAsString("day08.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(10, Day08.part2(getResourceAsString("day08-sample.txt")))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY08_PART2, Day08.part2(getResourceAsString("day08.txt")))
  }

}