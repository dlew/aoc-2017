import answer.Answer
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day17Test {

  @Test
  fun part1sample() {
    assertEquals(638, Day17.part1(3))
  }

  @Test
  fun part1() {
    assertEquals(Answer.DAY17_PART1, Day17.part1(355))
  }

  @Test
  fun part2() {
    assertEquals(Answer.DAY17_PART2, Day17.part2(355))
  }

}