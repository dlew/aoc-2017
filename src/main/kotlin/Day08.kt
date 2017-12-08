import utils.splitNewlines
import utils.splitWhitespace

object Day08 {

  fun part1(input: String): Int {
    val registers = mutableMapOf<String, Int>().withDefault { 0 }
    val instructions = input.splitNewlines().map(this::parseInstruction)
    for (instruction in instructions) {
      execute(registers, instruction)
    }
    return registers.maxValue()
  }

  fun part2(input: String): Int {
    val registers = mutableMapOf<String, Int>().withDefault { 0 }
    var maxValue = registers.maxValue()
    val instructions = input.splitNewlines().map(this::parseInstruction)
    for (instruction in instructions) {
      execute(registers, instruction)
      maxValue = maxOf(registers.maxValue(), maxValue)
    }
    return maxValue
  }

  data class Instruction(val register: String, val amount: Int, val condition: Condition)

  data class Condition(val leftOperand: String, val operator: String, val rightOperand: Int)

  private fun parseInstruction(instruction: String): Instruction {
    val split = instruction.splitWhitespace()
    val register = split[0]
    val incrementing = split[1] == "inc"
    val amount = split[2].toInt() * if (incrementing) 1 else -1
    val left = split[4]
    val operator = split[5]
    val right = split[6].toInt()

    return Instruction(
        register = register,
        amount = amount,
        condition = Condition(
            leftOperand = left,
            operator = operator,
            rightOperand = right
        )
    )
  }

  private fun execute(registers: MutableMap<String, Int>, instruction: Instruction) {
    if (checkCondition(registers, instruction.condition)) {
      val newValue = registers.getValue(instruction.register) + instruction.amount
      registers[instruction.register] = newValue
    }
  }

  private fun checkCondition(registers: Map<String, Int>, condition: Condition): Boolean {
    val leftOperand = registers.getValue(condition.leftOperand)
    return when (condition.operator) {
      ">" -> leftOperand > condition.rightOperand
      ">=" -> leftOperand >= condition.rightOperand
      "==" -> leftOperand == condition.rightOperand
      "!=" -> leftOperand != condition.rightOperand
      "<" -> leftOperand < condition.rightOperand
      "<=" -> leftOperand <= condition.rightOperand
      else -> throw IllegalArgumentException("Illegal operator: ${condition.operator}")
    }
  }

  private fun Map<String, Int>.maxValue() = values.max() ?: 0
}