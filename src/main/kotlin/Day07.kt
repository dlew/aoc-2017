import utils.splitCommas
import utils.splitNewlines
import java.util.regex.Pattern

object Day07 {

  private val PATTERN = Pattern.compile("(\\w+) \\((\\d+)\\)( -> (.*))?")

  data class Program(val name: String, val weight: Int, val holding: List<String>)

  data class BalanceInfo(val totalWeight: Int, val imbalanceNodeNewWeight: Int = 0)

  fun part1(input: String): String {
    val programs = parse(input)
    return findRoot(programs).name
  }

  fun part2(input: String): Int {
    val programs = parse(input)
    val root = findRoot(programs)
    val balance = balance(programs, root)
    return balance.imbalanceNodeNewWeight
  }

  private fun parse(input: String): Map<String, Program> {
    return input.splitNewlines().map { line ->
      val matcher = PATTERN.matcher(line)
      matcher.matches()
      val name = matcher.group(1)
      val weight = matcher.group(2).toInt()
      val holding = if (matcher.group(3) != null) {
        matcher.group(4).splitCommas()
      } else {
        emptyList()
      }

      return@map Program(name, weight, holding)
    }
        .associateBy { it.name }
  }

  private fun findRoot(programs: Map<String, Program>): Program {
    var filteredPrograms = programs

    while (filteredPrograms.size > 1) {
      filteredPrograms = filteredPrograms.filterValues { program ->
        program.holding.any { it in filteredPrograms }
      }
    }

    return filteredPrograms.values.first()
  }

  private fun balance(programs: Map<String, Program>, node: Program): BalanceInfo {
    if (node.holding.isEmpty()) {
      return BalanceInfo(node.weight)
    }

    // Recurse through all the children
    val children = node.holding.map { programs[it]!! }
    val balances = children.associate { child ->
      child to balance(programs, child)
    }

    // If we already found the imbalance, fall through
    val imbalanceFound = balances.values.firstOrNull { it.imbalanceNodeNewWeight != 0 }
    imbalanceFound?.let { return it }

    // Figure out if it's unbalanced
    val weights = balances.values.map { it.totalWeight }
    val weightMap = balances.values.groupingBy { it.totalWeight }.eachCount()

    if (weightMap.size == 1) {
      return BalanceInfo(weights.sum() + node.weight)
    }

    // We've found the unbalanced thing, figure out what to do
    val imbalancedWeight = weightMap.filterValues { it == 1 }.keys.first()
    val balancedWeight = weightMap.filterValues { it != 1 }.keys.first()
    val diff = balancedWeight - imbalancedWeight

    val imbalancedNode = balances.filterValues { it.totalWeight == imbalancedWeight }.keys.first()

    return BalanceInfo(0, imbalancedNode.weight + diff)
  }

}