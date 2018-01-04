import utils.splitNewlines

object Day24 {

  fun part1(input: String): Int {
    return strongestBridge(0, parseComponents(input))
  }

  fun part2(input: String): Int {
    return longestAndStrongestBridge(0, parseComponents(input)).strength
  }

  private fun strongestBridge(port: Int, components: List<Component>): Int {
    return components
        .filter { it.head == port || it.tail == port }
        .map { it.strength + strongestBridge(it.connect(port), components - it) }
        .max() ?: 0
  }

  private fun longestAndStrongestBridge(port: Int, components: List<Component>): Bridge {
    return components
        .filter { it.head == port || it.tail == port }
        .map { longestAndStrongestBridge(it.connect(port), components - it).withComponent(it) }
        .maxBy { it.comparable } ?: Bridge(0, 0)
  }

  private data class Component(val head: Int, val tail: Int) {
    val strength = head + tail

    fun connect(port: Int) = if (port == head) tail else head
  }

  private data class Bridge(val length: Int, val strength: Int) {
    val comparable = length * 10000 + strength

    fun withComponent(component: Component) = Bridge(length + 1, strength + component.strength)
  }

  private fun parseComponents(input: String): List<Component> {
    return input.splitNewlines().map {
      val split = it.split("/")
      Component(split[0].toInt(), split[1].toInt())
    }
  }


}