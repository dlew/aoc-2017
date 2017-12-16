import answer.Answer
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day19Test {

  @Test
  fun part1sample() {
    assertEquals("ABCDEF", Day19.part1(getResourceAsString("day19-sample.txt")))
  }

  @Test
  fun part1() {
    assertEquals(Answer.DAY19_PART1, Day19.part1(getResourceAsString("day19.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(38, Day19.part2(getResourceAsString("day19-sample.txt")))
  }

  @Test
  fun part2() {
    assertEquals(Answer.DAY19_PART2, Day19.part2(getResourceAsString("day19.txt")))
  }

}