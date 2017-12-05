import utils.splitNewlines
import utils.toIntList

object Day05 {

  fun stepsToEscape(input: String, usePartTwoRules: Boolean): Int {
    val instructions = input.splitNewlines().toIntList().toMutableList()
    var index = 0
    var steps = 0
    while (index in 0 until instructions.size) {
      val jump = instructions[index]
      instructions[index] += if (usePartTwoRules && jump >= 3) -1 else 1
      index += jump
      steps++
    }
    return steps
  }

}