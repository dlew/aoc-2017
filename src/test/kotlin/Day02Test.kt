import Day02.PUZZLE_INPUT
import Day02.maxMinusMin
import Day02.evenlyDivisibleNumbersQuotient
import org.junit.Assert.*
import org.junit.Test

class Day02Test {

    @Test fun validateSamplePartOne() {
        val sampleInput = "5 1 9 5\n" +
                "7 5 3\n" +
                "2 4 6 8"
        assertEquals(18, Day02.calculateSpreadsheetChecksum(sampleInput, maxMinusMin))
    }

    @Test fun calculatePartOne() {
        assertEquals(58975, Day02.calculateSpreadsheetChecksum(PUZZLE_INPUT, maxMinusMin))
    }

    @Test fun validateSamplePartTwo() {
        val sampleInput = "5 9 2 8\n" +
                "9 4 7 3\n" +
                "3 8 6 5"
        assertEquals(9, Day02.calculateSpreadsheetChecksum(sampleInput, evenlyDivisibleNumbersQuotient))
    }

    @Test fun calculatePartTwo() {
        assertEquals(308, Day02.calculateSpreadsheetChecksum(PUZZLE_INPUT, evenlyDivisibleNumbersQuotient))
    }
}