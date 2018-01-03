import utils.splitNewlines
import utils.splitWhitespace
import kotlin.math.sqrt

object Day21 {

  /*
   * Note to self: I setup pattern matching as a single row, where each cell is represented thus:
   *
   * 2x2
   *  01
   *  23
   *
   * 3x3
   *  012
   *  345
   *  678
   */

  private val START = listOf(
      false, true, false,
      false, false, true,
      true, true, true
  )

  fun solve(inputRules: String, iterations: Int): Int {
    val rules = parseRules(inputRules)

    var state = START
    (0 until iterations).forEach {
      val size = sqrt(state.size.toFloat()).toInt()
      val stepSize = if (size % 2 == 0) 2 else 3
      val newStepSize = stepSize + 1
      val newSize = newStepSize * (size / stepSize)
      val newState = BooleanArray(newSize * newSize).toMutableList()

      for (stepX in 0 until size / stepSize) {
        for (stepY in 0 until size / stepSize) {
          val input = slice(state, stepX * stepSize, stepY * stepSize, size, stepSize)
          val output = rules[input]!!
          insert(newState, stepX * newStepSize, stepY * newStepSize, newSize, newStepSize, output)
        }
      }

      state = newState
    }

    return state.count { it }
  }

  private fun slice(state: List<Boolean>, x: Int, y: Int, size: Int, sliceSize: Int): List<Boolean> {
    val result = mutableListOf<Boolean>()
    for (currY in y until y + sliceSize) {
      for (currX in x until x + sliceSize) {
        result.add(state[currY * size + currX])
      }
    }
    return result
  }

  private fun insert(state: MutableList<Boolean>, x: Int, y: Int, size: Int, insertSize: Int, insert: List<Boolean>) {
    var index = 0
    for (currY in y until y + insertSize) {
      for (currX in x until x + insertSize) {
        state[currY * size + currX] = insert[index++]
      }
    }
  }

  private fun parseRules(inputRules: String): Map<List<Boolean>, List<Boolean>> {
    val rules = mutableMapOf<List<Boolean>, List<Boolean>>()
    for (rule in inputRules.splitNewlines()) {
      val split = rule.replace("/", "").splitWhitespace()
      var input = split[0].map { it == '#' }
      val output = split[2].map { it == '#' }

      if (input.size == 4) {
        require(output.size == 9)
        (0..3).forEach {
          rules[input] = output
          rules[input.flip2()] = output
          input = input.rotate2()
        }
      } else {
        require(output.size == 16)
        (0..3).forEach {
          rules[input] = output
          rules[input.flip3()] = output
          input = input.rotate3()
        }
      }
    }
    return rules
  }

  private fun List<Boolean>.rotate2(): List<Boolean> {
    require(this.size == 4)
    return listOf(
        this[2], this[0],
        this[3], this[1]
    )
  }

  private fun List<Boolean>.flip2(): List<Boolean> {
    require(this.size == 4)
    return listOf(
        this[1], this[0],
        this[3], this[2]
    )
  }

  private fun List<Boolean>.rotate3(): List<Boolean> {
    require(this.size == 9)
    return listOf(
        this[6], this[3], this[0],
        this[7], this[4], this[1],
        this[8], this[5], this[2]
    )
  }

  private fun List<Boolean>.flip3(): List<Boolean> {
    require(this.size == 9)
    return listOf(
        this[2], this[1], this[0],
        this[5], this[4], this[3],
        this[8], this[7], this[6]
    )
  }
}