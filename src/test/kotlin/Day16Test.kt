import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitCommas
import utils.toIntList

class Day16Test {

  @Test
  fun part1sample() {
    assertEquals("baedc", Day16.part1("abcde", "s1,x3/4,pe/b"))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY16_PART1, Day16.part1("abcdefghijklmnop", getResourceAsString("day16.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals("ceadb", Day16.part2("abcde", "s1,x3/4,pe/b", 2))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY16_PART2, Day16.part2("abcdefghijklmnop", getResourceAsString("day16.txt"), 1000000000))
  }

}