import Day01.PUZZLE_INPUT
import Day01.sumAllDigitsThatMatchNextDigitInList
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith

class Day01Part01Test {

    @Test
    fun `Invalid Input throws Exception`() = assertFailsWith(IllegalArgumentException::class, null, {
        sumAllDigitsThatMatchNextDigitInList("Hello!")
    }).let {
        assertEquals("Not a digit: H", it.message)
    }

    @Test
    fun `Expect 3 from 1122`() = assertEquals(3, sumAllDigitsThatMatchNextDigitInList("1122"))

    @Test
    fun `Expect 4 from 1111`() = assertEquals(4, sumAllDigitsThatMatchNextDigitInList("1111"))

    @Test
    fun `Expect 0 from 1234`() = assertEquals(0, sumAllDigitsThatMatchNextDigitInList("1234"))

    @Test
    fun `Expect 9 from 91212129`() = assertEquals(9, sumAllDigitsThatMatchNextDigitInList("91212129"))

    @Test
    fun `Use my puzzle input`() = assertEquals(995, sumAllDigitsThatMatchNextDigitInList(PUZZLE_INPUT))
}