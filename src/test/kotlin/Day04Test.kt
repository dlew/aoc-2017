import answer.Answer
import answer.answerEquals
import org.junit.Test
import utils.getResourceAsString

class Day04Test {

  @Test
  fun part1() {
    answerEquals(Answer.DAY04_PART1, Day04.part1(getResourceAsString("day04.txt")))
  }

  @Test
  fun part2() {
    answerEquals(Answer.DAY04_PART2, Day04.part2(getResourceAsString("day04.txt")))
  }

}