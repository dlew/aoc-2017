import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils
import java.util.*

inline fun <T, R> Iterable<T>.scan(initial: R, operation: (R, T) -> R): Iterable<R> {
  val results = mutableListOf(initial)
  for (element in this) results += operation(results.last(), element)
  return results
}

fun <T, R> Sequence<T>.scan(initial: R, operation: (R, T) -> R): Sequence<R>
    = ScanningSequence(this, initial, operation)

internal class ScanningSequence<T, R>
constructor(private val sequence: Sequence<T>,
            private val initial: R,
            private val operation: (R, T) -> R) : Sequence<R> {

  override fun iterator(): Iterator<R> = object : Iterator<R> {
    val iterator = sequence.iterator()
    var state = initial

    override fun next(): R {
      state = operation(state, iterator.next())
      return state
    }

    override fun hasNext(): Boolean {
      return iterator.hasNext()
    }
  }
}

fun <T> Iterable<Iterable<T>>.transpose(): List<List<T>> {
  val results = ArrayList<MutableList<T>>()
  forEach { list ->
    list.forEachIndexed { i, item ->
      if (results.size <= i) {
        results.add(ArrayList<T>())
      }
      results[i].add(item)
    }
  }
  return results
}

fun <T> Iterable<T>.chunk(size: Int): Iterable<List<T>> {
  val results = ArrayList<MutableList<T>>()
  forEachIndexed { i, item ->
    if (i % size == 0) {
      results.add(ArrayList<T>())
    }
    results.last().add(item)
  }
  return results
}

fun <T> List<T>.slidingWindow(size: Int): Iterable<List<T>> {
  val results = ArrayList<List<T>>()
  (0..this.size - size).forEach {
    results.add(this.subList(it, it + size))
  }
  return results
}

fun <T> List<T>.window(width: Int): List<List<T>> =
    if (size < width) emptyList() else listOf(take(width)).plus(drop(1).window(width))

// Since this has come up multiple times in the puzzles...
fun Iterable<Char>.charCounts(): Map<Char, Int> {
  return fold(HashMap<Char, Int>(), { charCount, char ->
    charCount.put(char, charCount.getOrDefault(char, 0) + 1)
    charCount
  })
}

// A not-particularly-efficient combinations algorithm
fun <T> Collection<T>.combinations(n: Int): Collection<List<T>> {
  if (n == 0) {
    return listOf(emptyList())
  }

  if (size == 0) {
    return emptyList()
  }

  // Not strictly necessary, but a nice short-circuit
  if (n > size) {
    return emptyList()
  }

  val x = first()
  val xs = drop(1)
  return xs.combinations(n) + xs.combinations(n - 1).map { it.plus(x) }
}

fun String.md5(toLowerCase: Boolean = false) = Hex.encodeHex(DigestUtils.md5(this), toLowerCase).joinToString("")
