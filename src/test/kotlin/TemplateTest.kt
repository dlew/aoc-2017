import org.junit.Assert.assertEquals
import org.junit.Test
import utils.getResourceAsString

class TemplateTest {

  fun part1(input: String): Any {
    return input
  }

  fun part2(input: String): Any {
    return input
  }

  @Test
  fun part1sample() {
    assertEquals("Hello!", part1(getResourceAsString("template-sample.txt")))
  }

  @Test
  fun part1() {
    assertEquals("Hello, world!", part1(getResourceAsString("template.txt")))
  }

  @Test
  fun part2sample() {
    assertEquals("Hello!", part2(getResourceAsString("template-sample.txt")))
  }

  @Test
  fun part2() {
    assertEquals("Hello, world!", part2(getResourceAsString("template.txt")))
  }

}