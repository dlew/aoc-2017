import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class Day02Test {

  @Test
  fun part1sample() {
    assertEquals(18, Day02.checksum(getResourceAsString("day02-sample1.txt")))
  }

  @Test
  fun part1() {
    assertEquals(32121, Day02.checksum(getResourceAsString("day02.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals(9, Day02.checksum2(getResourceAsString("day02-sample2.txt")))
  }

  @Test
  fun part2() {
    assertEquals(197, Day02.checksum2(getResourceAsString("day02.txt")))
  }

}