import utils.splitCommas
import utils.toIntList

object Day16 {

  fun part1(programs: String, instructions: String): String {
    return dance(programs, parseInstructions(instructions))
  }

  fun part2(initialPrograms: String, inputInstructions: String, times: Int): String {
    val instructions = parseInstructions(inputInstructions)
    var programs = initialPrograms
    for (a in 0 until times % findCycleLength(initialPrograms, instructions)) {
      programs = dance(programs, instructions)
    }
    return programs
  }

  sealed class Instruction {
    data class Spin(val num: Int) : Instruction()
    data class Exchange(val a: Int, val b: Int) : Instruction()
    data class Partner(val a: Char, val b: Char) : Instruction()
  }

  private fun parseInstructions(inputInstructions: String): List<Instruction> {
    return inputInstructions.splitCommas().map { instruction ->
      when (instruction[0]) {
        's' -> Instruction.Spin(instruction.drop(1).toInt())
        'x' -> {
          val positions = instruction.drop(1).split("/").toIntList()
          Instruction.Exchange(positions[0], positions[1])
        }
        'p' -> Instruction.Partner(instruction[1], instruction[3])
        else -> throw IllegalArgumentException("Illegal instruction: $instruction")
      }
    }
  }

  private fun dance(initialPrograms: String, instructions: List<Instruction>): String {
    var programs = initialPrograms.toCharArray()
    var spinner = initialPrograms.toCharArray()
    val numPrograms = programs.size

    for (instruction in instructions) {
      when (instruction) {
        is Instruction.Spin -> {
          val rotate = numPrograms - instruction.num
          for (index in 0 until numPrograms) {
            spinner[index] = programs[(index + rotate) % numPrograms]
          }
          val tmp = programs
          programs = spinner
          spinner = tmp
        }

        is Instruction.Exchange -> programs.swap(instruction.a, instruction.b)

        is Instruction.Partner -> {
          programs.swap(programs.indexOf(instruction.a), programs.indexOf(instruction.b))
        }
      }
    }

    return programs.joinToString("")
  }

  private fun CharArray.swap(a: Int, b: Int) {
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
  }

  /**
   * Key insight: the instructions, applied over and over, eventually create a cycle, so you don't
   * actually need to apply it a billion times.
   */
  private fun findCycleLength(initialPrograms: String, instructions: List<Instruction>): Int {
    var programs = initialPrograms
    val seen = mutableSetOf<String>()
    var length = 0
    while (programs !in seen) {
      seen.add(programs)
      programs = dance(programs, instructions)
      length++
    }
    return length
  }

}