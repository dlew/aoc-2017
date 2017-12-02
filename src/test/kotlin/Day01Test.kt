import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day01Test {

  @Test
  fun part1samples() {
    assertEquals(3, Day01.sum("1122"))
    assertEquals(4, Day01.sum("1111"))
    assertEquals(0, Day01.sum("1234"))
    assertEquals(9, Day01.sum("91212129"))
  }

  @Test
  fun part1() {
    assertEquals(1136, Day01.sum(getResourceAsString("day01.txt")))
  }

  @Test
  fun part2samples() {
    assertEquals(6, Day01.sum2("1212"))
    assertEquals(0, Day01.sum2("1221"))
    assertEquals(4, Day01.sum2("123425"))
    assertEquals(12, Day01.sum2("123123"))
    assertEquals(4, Day01.sum2("12131415"))
  }

  @Test
  fun part2() {
    assertEquals(1092, Day01.sum2(getResourceAsString("day01.txt")))
  }
}