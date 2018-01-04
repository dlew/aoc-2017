import utils.splitNewlines
import utils.splitWhitespace

object Day18 {

  fun part1(input: String): Int {
    val instructions: List<Instruction> = input.splitNewlines().map(this::parseInstruction)
    val machine = Machine(instructions = instructions)

    var lastSendValue = 0
    do {
      val message = machine.nextMessage()
      if (message is Message.Send) {
        lastSendValue = message.number.toInt()
      }
    } while (message !is Message.Receive)

    return lastSendValue
  }

  fun part2(input: String): Int {
    val instructions: List<Instruction> = input.splitNewlines().map(this::parseInstruction)
    val machine0 = Machine(instructions = instructions, initialPValue = 0L)
    val machine1 = Machine(instructions = instructions, initialPValue = 1L)

    var count = 0
    do {
      val message0 = machine0.nextMessage()
      val message1 = machine1.nextMessage()

      if (message0 is Message.Send) {
        machine1.submit(message0.number)
      }

      if (message1 is Message.Send) {
        machine0.submit(message1.number)
        count++
      }

    } while (message0 is Message.Send || message1 is Message.Send)

    return count
  }

  private class Machine(private val instructions: List<Instruction>, initialPValue: Long = 0L) {

    private var pointer: Int = 0
    private val registers: MutableMap<Char, Long> = mutableMapOf<Char, Long>().withDefault { 0 }
    private val queue: MutableList<Long> = mutableListOf()

    init {
      registers['p'] = initialPValue
    }

    fun nextMessage(): Message {
      while (pointer < instructions.size) {
        val instruction = instructions[pointer]

        when (instruction) {
          is Instruction.Send -> {
            pointer++
            return Message.Send(instruction.source.getValue(registers))
          }
          is Instruction.Modify -> {
            val curr = registers.getValue(instruction.target)
            val value = instruction.source.getValue(registers)

            registers[instruction.target] = when (instruction.operation) {
              Operation.SET -> value
              Operation.ADD -> curr + value
              Operation.MULTIPLY -> curr * value
              Operation.MODULO -> curr % value
            }

            pointer++
          }
          is Instruction.Receive -> {
            if (queue.isEmpty()) {
              return Message.Receive()
            } else {
              pointer++
              registers[instruction.register] = queue.removeAt(0)
            }
          }
          is Instruction.Jump -> {
            if (instruction.check.getValue(registers) > 0) {
              pointer += instruction.offset.getValue(registers).toInt()
            } else {
              pointer++
            }
          }
        }
      }

      throw IllegalStateException("Should deadlock, NOT end execution!")
    }

    fun submit(value: Long) {
      queue.add(value)
    }
  }

  private sealed class Message {
    class Send(val number: Long) : Message()

    class Receive : Message()
  }

  private sealed class Instruction {
    class Send(val source: ValueSource) : Instruction()

    class Modify(val operation: Operation, val target: Char, val source: ValueSource) : Instruction()

    class Receive(val register: Char) : Instruction()

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
    ADD,
    MULTIPLY,
    MODULO
  }

  private fun parseInstruction(input: String): Instruction {
    val split = input.splitWhitespace()
    val arg1 = split[1]
    val arg2 = if (split.size == 3) split[2] else ""

    fun parseSource(source: String): ValueSource {
      return if (source[0] in 'a'..'z') ValueSource.Register(source[0]) else ValueSource.Number(source.toLong())
    }

    return when (input.take(3)) {
      "snd" -> Instruction.Send(parseSource(split[1]))
      "set" -> Instruction.Modify(Operation.SET, arg1[0], parseSource(arg2))
      "add" -> Instruction.Modify(Operation.ADD, arg1[0], parseSource(arg2))
      "mul" -> Instruction.Modify(Operation.MULTIPLY, arg1[0], parseSource(arg2))
      "mod" -> Instruction.Modify(Operation.MODULO, arg1[0], parseSource(arg2))
      "rcv" -> Instruction.Receive(arg1[0])
      "jgz" -> Instruction.Jump(parseSource(arg1), parseSource(arg2))
      else -> throw IllegalArgumentException("Cannot parse $input")
    }
  }

}