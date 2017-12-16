import answer.Answer
import answer.answerEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day09Test {

  @Test
  fun part1sample() {
    assertEquals(1, Day09.part1("{}"))
    assertEquals(6, Day09.part1("{{{}}}"))
    assertEquals(5, Day09.part1("{{},{}}"))
    assertEquals(16, Day09.part1("{{{},{},{{}}}}"))
    assertEquals(1, Day09.part1("{<a>,<a>,<a>,<a>}"))
    assertEquals(9, Day09.part1("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
    assertEquals(9, Day09.part1("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
    assertEquals(3, Day09.part1("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
  }

  @Test
  fun part1() {
    answerEquals(Answer.DAY09_PART1, Day09.part1(getResourceAsString("day09.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(0, Day09.part2("<>"))
    assertEquals(17, Day09.part2("<random characters>"))
    assertEquals(3, Day09.part2("<<<<>"))
    assertEquals(2, Day09.part2("<{!>}>"))
    assertEquals(0, Day09.part2("<!!>"))
    assertEquals(0, Day09.part2("<!!!>>"))
    assertEquals(10, Day09.part2("<{o\"i!a,<{i<a>"))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY09_PART2, Day09.part2(getResourceAsString("day09.txt")))
  }

}