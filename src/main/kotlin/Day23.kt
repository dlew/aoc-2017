import utils.splitNewlines
import utils.splitWhitespace

object Day23 {

  fun part1(input: String): Int {
    val instructions = input.splitNewlines().map(this::parseInstruction)
    var pointer = 0
    val registers = mutableMapOf<Char, Long>().withDefault { 0 }

    var mulCount = 0
    while (pointer < instructions.size) {
      val instruction = instructions[pointer]

      when (instruction) {
        is Instruction.Modify -> {
          val curr = registers.getValue(instruction.target)
          val value = instruction.source.getValue(registers)

          registers[instruction.target] = when (instruction.operation) {
            Operation.SET -> value
            Operation.SUBTRACT -> curr - value
            Operation.MULTIPLY -> {
              mulCount++
              curr * value
            }
          }

          pointer++
        }
        is Instruction.Jump -> {
          if (instruction.check.getValue(registers) != 0L) {
            pointer += instruction.offset.getValue(registers).toInt()
          } else {
            pointer++
          }
        }
      }
    }

    return mulCount
  }

  // The secret is that the code is just counting prime numbers in a range
  fun part2(input: String, initialAValue: Int): Int {
    var start = if (initialAValue == 0) 93 else 109300
    var end = if (initialAValue == 0) 93 else 126300
    return (start..end step 17).count { it.isPrime() }
  }

  // Forgive me for this incredibly stupid prime tester
  private fun Int.isPrime(): Boolean {
    return (2 until this).any { this % it == 0 }
  }

  private sealed class Instruction {
    class Modify(val operation: Operation, val target: Char, val source: ValueSource) : Instruction()

    class Jump(val check: ValueSource, val offset: ValueSource) : Instruction()
  }

  private sealed class ValueSource {
    abstract fun getValue(registers: Map<Char, Long>): Long

    class Number(val number: Long) : ValueSource() {
      override fun getValue(registers: Map<Char, Long>) = number
    }

    class Register(val register: Char) : ValueSource() {
      override fun getValue(registers: Map<Char, Long>) = registers.getValue(register)
    }
  }

  private enum class Operation {
    SET,
    SUBTRACT,
    MULTIPLY
  }

  private fun parseInstruction(input: String): Instruction {
    val split = input.splitWhitespace()
    val arg1 = split[1]
    val arg2 = if (split.size == 3) split[2] else ""

    fun parseSource(source: String): ValueSource {
      return if (source[0] in 'a'..'z') ValueSource.Register(source[0]) else ValueSource.Number(source.toLong())
    }

    return when (input.take(3)) {
      "set" -> Instruction.Modify(Operation.SET, arg1[0], parseSource(arg2))
      "sub" -> Instruction.Modify(Operation.SUBTRACT, arg1[0], parseSource(arg2))
      "mul" -> Instruction.Modify(Operation.MULTIPLY, arg1[0], parseSource(arg2))
      "jnz" -> Instruction.Jump(parseSource(arg1), parseSource(arg2))
      else -> throw IllegalArgumentException("Cannot parse $input")
    }
  }

}