import utils.splitWhitespace
import utils.toIntList

object Day06 {

  fun part1(input: String): Int {
    var banks = input.splitWhitespace().toIntList()
    val seen = mutableSetOf<List<Int>>()

    var steps = 0
    while (!seen.contains(banks)) {
      seen.add(banks)
      val indexToRedistribute = maxBankIndex(banks)
      banks = redistribute(banks, indexToRedistribute)
      steps++
    }

    return steps
  }

  fun part2(input: String): Int {
    var banks = input.splitWhitespace().toIntList()
    val seen = mutableMapOf<List<Int>, Int>()

    var cycle = 0
    while (!seen.containsKey(banks)) {
      seen[banks] = cycle
      val indexToRedistribute = maxBankIndex(banks)
      banks = redistribute(banks, indexToRedistribute)
      cycle++
    }

    return cycle - seen[banks]!!
  }

  private fun maxBankIndex(banks: List<Int>): Int {
    var max = -1
    var maxIndex = -1
    for (index in 0 until banks.size) {
      val bank = banks[index]
      if (bank > max) {
        max = bank
        maxIndex = index
      }
    }
    return maxIndex
  }

  private fun redistribute(banks: List<Int>, index: Int): List<Int> {
    val newBanks = banks.toMutableList()
    val value = newBanks[index]
    newBanks[index] = 0

    for (offset in 1..value) {
      newBanks[(index + offset) % banks.size]++
    }

    return newBanks
  }

}