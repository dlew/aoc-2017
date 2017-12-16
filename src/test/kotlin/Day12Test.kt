import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitCommas
import utils.splitNewlines
import utils.toIntList
import java.util.regex.Pattern

class Day12Test {

  @Test
  fun part1sample() {
    assertEquals(6, Day12.part1(getResourceAsString("day12-sample.txt")))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY12_PART1, Day12.part1(getResourceAsString("day12.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(2, Day12.part2(getResourceAsString("day12-sample.txt")))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY12_PART2, Day12.part2(getResourceAsString("day12.txt")))
  }

}