import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.coroutines.experimental.buildSequence

class Day15Test {

  @Test
  fun part1sample() {
    assertEquals(588, Day15.part1(65, 8921))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY15_PART1, Day15.part1(512, 191))
  }

  @Test
  fun part2sample() {
    assertEquals(309, Day15.part2(65, 8921))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY15_PART2, Day15.part2(512, 191))
  }

}