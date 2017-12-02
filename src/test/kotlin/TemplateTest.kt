import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class TemplateTest {

  @Test
  fun part1sample() {
    assertEquals("Hello!", Template.part1(getResourceAsString("template-sample1.txt")))
  }

  @Test
  fun part1() {
    assertEquals("Hello, world!", Template.part1(getResourceAsString("template.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals("Goodbye!", Template.part2(getResourceAsString("template-sample2.txt")))
  }

  @Test
  fun part2() {
    assertEquals("Hello, world!", Template.part2(getResourceAsString("template.txt")))
  }

}