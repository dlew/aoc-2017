package grid

inline fun <reified T> generateGrid(width: Int, height: Int, initialValue: T): Array<Array<T>> {
  return Array(height, { Array(width, { initialValue }) })
}

fun generateGrid(width: Int, height: Int, initialValue: Boolean = false): Array<BooleanArray> {
  return Array(height, { BooleanArray(width, { initialValue }) })
}

fun generateGrid(width: Int, height: Int, initialValue: Char = ' '): Array<CharArray> {
  return Array(height, { CharArray(width, { initialValue }) })
}

fun generateGrid(width: Int, height: Int, initialValue: Byte = 0): Array<ByteArray> {
  return Array(height, { ByteArray(width, { initialValue }) })
}

fun generateGrid(width: Int, height: Int, initialValue: Short = 0): Array<ShortArray> {
  return Array(height, { ShortArray(width, { initialValue }) })
}

fun generateGrid(width: Int, height: Int, initialValue: Int = 0): Array<IntArray> {
  return Array(height, { IntArray(width, { initialValue }) })
}

fun generateGrid(width: Int, height: Int, initialValue: Long = 0): Array<LongArray> {
  return Array(height, { LongArray(width, { initialValue }) })
}

fun generateGrid(width: Int, height: Int, initialValue: Float = 0f): Array<FloatArray> {
  return Array(height, { FloatArray(width, { initialValue }) })
}

fun generateGrid(width: Int, height: Int, initialValue: Double = 0.0): Array<DoubleArray> {
  return Array(height, { DoubleArray(width, { initialValue }) })
}
