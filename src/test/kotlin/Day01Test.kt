import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day01Test {

  @Test
  fun part1samples() {
    assertEquals(3, Day01.part1("1122"))
    assertEquals(4, Day01.part1("1111"))
    assertEquals(0, Day01.part1("1234"))
    assertEquals(9, Day01.part1("91212129"))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY01_PART1, Day01.part1(getResourceAsString("day01.txt")))
  }

  @Test
  fun part2samples() {
    assertEquals(6, Day01.part2("1212"))
    assertEquals(0, Day01.part2("1221"))
    assertEquals(4, Day01.part2("123425"))
    assertEquals(12, Day01.part2("123123"))
    assertEquals(4, Day01.part2("12131415"))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY01_PART2, Day01.part2(getResourceAsString("day01.txt")))
  }
}