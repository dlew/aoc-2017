import org.junit.Assert.assertEquals
import org.junit.Test
import utils.*
import java.util.*

class Day10Test {

  @Test
  fun part1sample() {
    assertEquals(12, Day10.part1("3,4,1,5", 5))
  }

  @Test
  fun part1() {
    assertEquals(13760, Day10.part1("227,169,3,166,246,201,0,47,1,255,2,254,96,3,97,144"))
  }

  @Test
  fun part2sample() {
    assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Day10.part2(""))
    assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Day10.part2("AoC 2017"))
    assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10.part2("1,2,3"))
    assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Day10.part2("1,2,4"))
  }

  @Test
  fun part2() {
    assertEquals("2da93395f1a6bb3472203252e3b17fe5",
        Day10.part2("227,169,3,166,246,201,0,47,1,255,2,254,96,3,97,144"))
  }

}