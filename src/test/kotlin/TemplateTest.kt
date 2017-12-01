import org.junit.Assert.assertEquals
import org.junit.Test

class TemplateTest {

  @Test
  fun part1sample() {
    assertEquals("", Template.part1(""))
  }

  @Test
  fun part1() {
    assertEquals("", Template.part1(getResourceAsString("template.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals("", Template.part2(""))
  }

  @Test
  fun part2() {
    assertEquals("", Template.part2(getResourceAsString("template.txt")))
  }

}