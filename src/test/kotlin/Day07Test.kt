import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitCommas
import utils.splitNewlines
import java.util.regex.Pattern

class Day07Test {

  @Test
  fun part1sample() {
    assertEquals("tknk", Day07.part1(getResourceAsString("day07-sample.txt")))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY07_PART1, Day07.part1(getResourceAsString("day07.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(60, Day07.part2(getResourceAsString("day07-sample.txt")))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY07_PART2, Day07.part2(getResourceAsString("day07.txt")))
  }

}