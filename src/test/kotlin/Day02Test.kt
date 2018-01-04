import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day02Test {

  @Test
  fun part1sample() {
    assertEquals(18, Day02.part1(getResourceAsString("day02-sample1.txt")))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY02_PART1, Day02.part1(getResourceAsString("day02.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(9, Day02.part2(getResourceAsString("day02-sample2.txt")))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY02_PART2, Day02.part2(getResourceAsString("day02.txt")))
  }

}