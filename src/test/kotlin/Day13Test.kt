import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitNewlines
import utils.toIntList

class Day13Test {

  @Test
  fun part1sample() {
    assertEquals(24, Day13.part1(getResourceAsString("day13-sample.txt")))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY13_PART1, Day13.part1(getResourceAsString("day13.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(10, Day13.part2(getResourceAsString("day13-sample.txt")))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY13_PART2, Day13.part2(getResourceAsString("day13.txt")))
  }

}