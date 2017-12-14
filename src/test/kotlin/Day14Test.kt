import grid.Point
import org.junit.Assert.assertEquals
import org.junit.Test

class Day14Test {

  @Test
  fun part1sample() {
    assertEquals(8108, Day14.part1("flqrgnkx"))
  }

  @Test
  fun part1() {
    assertEquals(8204, Day14.part1("xlqgujun"))
  }

  @Test
  fun part2sample() {
    assertEquals(1242, Day14.part2("flqrgnkx"))
  }

  @Test
  fun part2() {
    assertEquals(1089, Day14.part2("xlqgujun"))
  }

}