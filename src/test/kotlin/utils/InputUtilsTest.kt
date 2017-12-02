package utils

import org.junit.Assert.assertEquals
import org.junit.Test

class InputUtilsTest {

  @Test
  fun splitNewLines() {
    val input = """line1
      |line2
      |line3""".trimMargin()

    assertEquals(listOf("line1", "line2", "line3"), input.splitNewlines())
  }

  @Test
  fun spliteWhitespace() {
    assertEquals(listOf("1", "22", "333"), "1 22 333".splitWhitespace())
    assertEquals(listOf("1", "22", "333"), "1     22  333".splitWhitespace())
    assertEquals(listOf("1", "22", "333"), "1\t\t22\t333".splitWhitespace())
    assertEquals(listOf("1", "22", "333"), "1 22 333   ".splitWhitespace())
    assertEquals(listOf("1", "22", "333"), "  1 22 333".splitWhitespace())
  }

  @Test
  fun splitCommas() {
    assertEquals(listOf("1", "22", "333"), "1,22,333".splitCommas())
    assertEquals(listOf("1", "22", "333"), "1, 22, 333".splitCommas())
    assertEquals(listOf("1", "22", "333"), "1,\t\t22,\t333".splitCommas())
    assertEquals(listOf("1", "22", "333"), "1,22,333  ".splitCommas())
    assertEquals(listOf("1", "22", "333"), "  1,22,333  ".splitCommas())
  }

  @Test
  fun strToIntList() {
    assertEquals(listOf(1, 4, 9), "149".toIntList())
    assertEquals(listOf(1, 4, 9), "149  ".toIntList())
    assertEquals(listOf(1, 4, 9), "   149".toIntList())
  }

  @Test
  fun charArrayToIntList() {
    assertEquals(listOf(1, 4, 9), "149".toCharArray().toIntList())
  }

  @Test
  fun strListToIntList() {
    assertEquals(listOf(1, 4, 9), listOf("1", "4", "9").toIntList())
    assertEquals(listOf(15, 42, 993), listOf("15", "42", "993").toIntList())
    assertEquals(listOf(15, 42, 993), listOf("15  ", "  42", "  993  ").toIntList())
  }
}