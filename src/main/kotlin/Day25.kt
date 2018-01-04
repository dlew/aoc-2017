import grid.Turn
import utils.splitNewlines
import java.util.regex.Matcher
import java.util.regex.Pattern

object Day25 {

  fun part1(input: String): Int {
    val blueprint = parseBlueprint(input)

    val states = blueprint.states.associateBy { it.name }
    var tape = mutableSetOf<Int>()
    var position = 0
    var state = blueprint.initialState
    for (step in 0 until blueprint.checksumSteps) {
      val stateInstructions = states[state]!!
      val isOne = tape.contains(position)
      val instruction = if (isOne) stateInstructions.ifOne else stateInstructions.ifZero

      // Write
      if (instruction.write) {
        tape.add(position)
      }
      else if (!instruction.write) {
        tape.remove(position)
      }

      // Move
      position += if (instruction.move == Turn.LEFT) -1 else 1

      // Next state
      state = instruction.nextState
    }

    return tape.size
  }

  data class Blueprint(val initialState: Char, val checksumSteps: Int, val states: List<State>)

  data class State(val name: Char, val ifZero: Instruction, val ifOne: Instruction)

  data class Instruction(val write: Boolean, val move: Turn, val nextState: Char)

  private fun parseBlueprint(input: String): Blueprint {
    val lines = input.splitNewlines()
    val initialState = BEGIN_PATTERN.extract(lines[0]).group(1)[0]
    val checksum = CHECKSUM_PATTERN.extract(lines[1]).group(1).toInt()

    val states = mutableListOf<State>()
    lines.forEachIndexed { index, line ->
      val stateMatcher = IN_PATTERN.matcher(line)
      if (stateMatcher.matches()) {
        var name = stateMatcher.group(1)[0]
        val ifZero = Instruction(
            write = WRITE_PATTERN.extract(lines[index + 2].trim()).group(1) == "1",
            move = if (MOVE_PATTERN.extract(lines[index + 3].trim()).group(1) == "left") Turn.LEFT else Turn.RIGHT,
            nextState = CONTINUE_PATTERN.extract(lines[index + 4].trim()).group(1)[0]
        )
        val ifOne = Instruction(
            write = WRITE_PATTERN.extract(lines[index + 6].trim()).group(1) == "1",
            move = if (MOVE_PATTERN.extract(lines[index + 7].trim()).group(1) == "left") Turn.LEFT else Turn.RIGHT,
            nextState = CONTINUE_PATTERN.extract(lines[index + 8].trim()).group(1)[0]
        )

        states.add(Day25.State(name, ifZero, ifOne))
      }
    }

    return Blueprint(initialState, checksum, states)
  }

  private fun Pattern.extract(input: CharSequence): Matcher {
    val matcher = matcher(input)
    matcher.matches()
    return matcher
  }

  private val BEGIN_PATTERN = Pattern.compile("Begin in state (\\w)\\.")
  private val CHECKSUM_PATTERN = Pattern.compile("Perform a diagnostic checksum after (\\d+) steps\\.")
  private val IN_PATTERN = Pattern.compile("In state (\\w):")
  private val WRITE_PATTERN = Pattern.compile("- Write the value (0|1)\\.")
  private val MOVE_PATTERN = Pattern.compile("- Move one slot to the (right|left)\\.")
  private val CONTINUE_PATTERN = Pattern.compile("- Continue with state (\\w)\\.")

}