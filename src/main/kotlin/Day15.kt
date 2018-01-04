import kotlin.coroutines.experimental.buildSequence

object Day15 {

  fun part1(startA: Int, startB: Int): Int {
    val generatorA = makeGenerator(startA, 16807)
    val generatorB = makeGenerator(startB, 48271)
    return matches(generatorA, generatorB, 40000000)
  }

  fun part2(startA: Int, startB: Int): Int {
    val generatorA = makeGenerator(startA, 16807, 4)
    val generatorB = makeGenerator(startB, 48271, 8)
    return matches(generatorA, generatorB, 5000000)
  }

  private fun makeGenerator(start: Int, multiplier: Long, multiple: Int = 1): Sequence<Int> {
    return buildSequence {
      var curr = start
      while (true) {
        curr = (curr * multiplier % 2147483647L).toInt()
        if (multiple == 1 || curr % multiple == 0) {
          yield(curr)
        }
      }
    }
  }

  private fun matches(generatorA: Sequence<Int>, generatorB: Sequence<Int>, times: Int): Int {
    val iteratorA = generatorA.iterator()
    val iteratorB = generatorB.iterator()
    return (0 until times).count { iteratorA.next().toShort() == iteratorB.next().toShort() }
  }

}