import Day01.PUZZLE_INPUT
import Day01.sumAllDigitsThatMatchHalfwayAroundDigitInList
import org.junit.Assert
import org.junit.Test
import kotlin.test.*

class Day01Part02Test {

    @Test
    fun `Invalid Input throws Exception`() = assertFailsWith(IllegalArgumentException::class, null, {
        sumAllDigitsThatMatchHalfwayAroundDigitInList("123")
    }).let { Assert.assertEquals("Input length must be an even number.", it.message) }

    @Test
    fun `Expect 6 from 1212`() = assertEquals(6, sumAllDigitsThatMatchHalfwayAroundDigitInList("1212"))

    @Test
    fun `Expect 0 from 1221`() = assertEquals(0, sumAllDigitsThatMatchHalfwayAroundDigitInList("1221"))

    @Test
    fun `Expect 4 from 123425`() = assertEquals(4, sumAllDigitsThatMatchHalfwayAroundDigitInList("123425"))

    @Test
    fun `Expect 12 from 123123`() = assertEquals(12, sumAllDigitsThatMatchHalfwayAroundDigitInList("123123"))

    @Test
    fun `Expect 4 from 12131415`() = assertEquals(4, sumAllDigitsThatMatchHalfwayAroundDigitInList("12131415"))

    @Test
    fun `Use my puzzle input`() = assertEquals(1130, sumAllDigitsThatMatchHalfwayAroundDigitInList(PUZZLE_INPUT))
}