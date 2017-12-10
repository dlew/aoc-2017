import utils.splitCommas
import utils.toIntList
import java.util.*

object Day10 {

  fun part1(input: String, size: Int = 256): Int {
    val list = (0 until size).toMutableList()
    val lengths = input.splitCommas().toIntList()
    hash(list, lengths)
    return list[0] * list[1]
  }

  fun part2(input: String): String {
    val list = (0 until 256).toMutableList()
    val lengths = input.map { it.toInt() } + listOf(17, 31, 73, 47, 23)

    var hashState = HashState(0, 0)
    for (a in 0 until 64) {
      hashState = hash(list, lengths, hashState)
    }

    return list.chunked(16)
        .map { it.reduce { acc, i -> acc.xor(i) } }
        .joinToString("") { "%02x".format(it) }
  }

  data class HashState(val position: Int, val skipSize: Int)

  private fun hash(list: MutableList<Int>,
                   lengths: List<Int>,
                   hashState: HashState = HashState(0, 0)): HashState {
    val size = list.size

    var position = hashState.position
    var skipSize = hashState.skipSize

    for (length in lengths) {
      reverse(list, position, position + length)
      position = (position + length + skipSize) % size
      skipSize++
    }

    return HashState(position, skipSize)
  }

  private fun reverse(list: MutableList<Int>, fromInclusive: Int, toExclusive: Int) {
    val mid = (fromInclusive + toExclusive) / 2
    val length = (toExclusive - fromInclusive)
    for (a in (0 until length)) {
      val reversePosition = fromInclusive + a
      if (reversePosition >= mid) {
        return
      }

      val i = reversePosition % list.size
      val j = (toExclusive - a - 1) % list.size
      Collections.swap(list, i, j)
    }
  }

}