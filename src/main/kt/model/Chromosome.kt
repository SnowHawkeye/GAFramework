package main.kt.model

abstract class Chromosome(
    val genes: List<Gene>,
) {
    abstract fun computeFitness(): Int
}