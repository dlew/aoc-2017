import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString
import utils.splitCommas
import kotlin.math.abs

class Day11Test {

  @Test
  fun part1sample() {
    assertEquals(3, Day11.part1("ne,ne,ne"))
    assertEquals(0, Day11.part1("ne,ne,sw,sw"))
    assertEquals(2, Day11.part1("ne,ne,s,s"))
    assertEquals(3, Day11.part1("se,sw,se,sw,sw"))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY11_PART1, Day11.part1(getResourceAsString("day11.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(3, Day11.part2("ne,ne,ne"))
    assertEquals(2, Day11.part2("ne,ne,sw,sw"))
    assertEquals(2, Day11.part2("ne,ne,s,s"))
    assertEquals(3, Day11.part2("se,sw,se,sw,sw"))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY11_PART2, Day11.part2(getResourceAsString("day11.txt")))
  }

}