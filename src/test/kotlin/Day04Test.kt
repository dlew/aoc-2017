import answer.Answer
import answer.answerEquals
import org.junit.Assert.*
import org.junit.Test
import utils.getResourceAsString
import utils.splitNewlines

class Day04Test {

  @Test
  fun part1sample() {
    assertTrue(Day04.part1("aa bb cc dd ee"))
    assertFalse(Day04.part1("aa bb cc dd aa"))
    assertTrue(Day04.part1("aa bb cc dd aaa"))
  }

  @Test
  fun part1() {
    val count = getResourceAsString("day04.txt").splitNewlines()
        .sumBy { if (Day04.part1(it)) 1 else 0 }

    answerEquals(Answer.DAY04_PART1, count)
  }

  @Test
  fun part2sample() {
    assertTrue(Day04.part2("abcde fghij"))
    assertFalse(Day04.part2("abcde xyz ecdab"))
    assertTrue(Day04.part2("a ab abc abd abf abj"))
    assertTrue(Day04.part2("iiii oiii ooii oooi oooo"))
    assertFalse(Day04.part2("oiii ioii iioi iiio"))
  }

  @Test
  fun part2() {
    val count = getResourceAsString("day04.txt").splitNewlines()
        .sumBy { if (Day04.part2(it)) 1 else 0 }

    answerEquals(Answer.DAY04_PART2, count)
  }

}