package answer

import org.junit.Assert

/**
 * Same as assertEquals(), only it doesn't give away the answer in the error message.
 */
fun answerEquals(expected: Any, actual: Any) {
  if (expected != actual) {
    Assert.fail("$actual is not the correct answer!")
  }
}