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
    assertEquals("eqgvf", Day07.part1(getResourceAsString("day07.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(60, Day07.part2(getResourceAsString("day07-sample.txt")))
  }

  @Test
  fun part2() {
    assertEquals(757, Day07.part2(getResourceAsString("day07.txt")))
  }

}