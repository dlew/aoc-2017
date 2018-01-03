import utils.splitNewlines
import java.util.regex.Pattern
import kotlin.math.abs

object Day20 {

  private val PATTERN = Pattern.compile("p=<(-?\\d+),(-?\\d+),(-?\\d+)>, v=<(-?\\d+),(-?\\d+),(-?\\d+)>, a=<(-?\\d+),(-?\\d+),(-?\\d+)>")

  fun part1(input: String): Int {
    val particles = parseParticles(input)
    return particles.indexOf(particles.minBy { it.acceleration.manhattan })
  }

  fun part2(input: String): Int {
    var particles = parseParticles(input)

    do {
      // Remove any collided particles
      particles -= particles.groupBy { it.position }.values.filter { it.size > 1 }.flatMap { it }

      // Update the particles
      val updatedParticles = particles.map(Particle::tick)

      // Check for base conditions
      val areAnyParticlesMovingTowardsEachOther = areAnyParticlesMovingTowardsEachOther(particles, updatedParticles)

      // Swap particle data
      particles = updatedParticles
    } while (areAnyParticlesMovingTowardsEachOther)

    return particles.size
  }

  private fun areAnyParticlesMovingTowardsEachOther(before: List<Particle>, after: List<Particle>): Boolean {
    require(before.size == after.size)

    val size = before.size
    for (a in 0 until size) {
      for (b in a until size) {
        if (before[a].distanceTo(before[b]) > after[a].distanceTo(after[b])) {
          return true
        }
      }
    }

    return false
  }

  data class XYZ(val x: Int, val y: Int, val z: Int) {
    val manhattan = abs(x) + abs(y) + abs(z)

    fun add(other: XYZ) = XYZ(x + other.x, y + other.y, z + other.z)
  }

  data class Particle(val position: XYZ, val velocity: XYZ, val acceleration: XYZ) {
    fun tick(): Particle {
      val velocity = velocity.add(acceleration)
      val position = position.add(velocity)
      return Particle(
          position = position,
          velocity = velocity,
          acceleration = acceleration
      )
    }

    fun distanceTo(other: Particle): Int {
      return abs(position.x - other.position.x) +
          abs(position.y - other.position.y) +
          abs(position.z - other.position.z)
    }
  }

  private fun parseParticles(input: String) = input.splitNewlines().map(this::parseParticle)

  private fun parseParticle(line: String): Particle {
    val matcher = PATTERN.matcher(line)
    matcher.matches()
    return Particle(
        position = XYZ(matcher.group(1).toInt(), matcher.group(2).toInt(), matcher.group(3).toInt()),
        velocity = XYZ(matcher.group(4).toInt(), matcher.group(5).toInt(), matcher.group(6).toInt()),
        acceleration = XYZ(matcher.group(7).toInt(), matcher.group(8).toInt(), matcher.group(9).toInt())
    )
  }

}