package utils

import java.util.regex.Pattern

/**
 * Convenience methods for manipulating string inputs.
 *
 * Generally forgiving of whitespace.
 */

private val NEWLINE = Pattern.compile("\\r?\\n")
private val WHITESPACE = Pattern.compile("\\s+")
private val COMMA = Pattern.compile(",\\s*")

fun CharSequence.splitNewlines(): List<String> {
  return trim().split(NEWLINE)
}

fun CharSequence.splitWhitespace(): List<String> {
  return trim().split(WHITESPACE)
}

fun CharSequence.splitCommas(): List<String> {
  return trim().split(COMMA)
}

fun String.toIntList(): List<Int> {
  return trim().map { it.toString().toInt() }
}

fun CharArray.toIntList(): List<Int> {
  return map { it.toString().toInt() }
}

fun List<String>.toIntList(): List<Int> {
  return map { it.trim().toInt() }
}