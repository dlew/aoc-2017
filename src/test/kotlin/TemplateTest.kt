import org.junit.Assert.assertEquals
import org.junit.Test

class TemplateTest {

  @Test
  fun sample() {
    val input = getResourceAsString("template.txt")
    assertEquals("Hello, world!", input)
  }

  @Test
  fun window() {
    assertEquals(listOf(listOf(1, 2, 3), listOf(2, 3, 4)), listOf(1, 2, 3, 4).windowed(3))
  }

  @Test
  fun chunked() {
    assertEquals(listOf(listOf(1, 2, 3), listOf(4)), listOf(1, 2, 3, 4).chunked(3))
  }

}