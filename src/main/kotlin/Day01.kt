import utils.toIntList

object Day01 {

  fun sum(input: String): Int {
    val intInput = input.toIntList()
    val circledInput = intInput + listOf(intInput[0])
    return circledInput.windowed(2)
        .filter { it[0] == it[1] }
        .sumBy { it[0] }
  }

  fun sum2(input: String): Int {
    val intInput = input.toIntList()
    val size = intInput.size
    val halfSize = size / 2
    val doubleInput = intInput + intInput
    return (0 until size)
        .filter { doubleInput[it] == doubleInput[it + halfSize] }
        .sumBy { doubleInput[it] }
  }

}