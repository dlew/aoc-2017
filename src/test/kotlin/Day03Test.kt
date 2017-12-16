import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class Day03Test {

  @Test
  fun part1sample() {
    assertEquals(1, Day03.part1(1))
    assertEquals(3, Day03.part1(12))
    assertEquals(2, Day03.part1(23))
    assertEquals(31, Day03.part1(1024))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY03_PART1, Day03.part1(368078))
  }

  @Test
  fun part2sample() {
    assertEquals(54, Day03.part2(28))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY03_PART2, Day03.part2(368078))
  }

}