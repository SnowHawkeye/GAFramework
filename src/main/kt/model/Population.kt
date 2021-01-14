package main.kt.model

abstract class Population(
    val individuals: List<Chromosome>
) {

    fun findBest(): Int {
        return individuals.maxOf { it.computeFitness() }
    }

    abstract class PopulationFactory<P : Population> {
        abstract fun generatePopulation(): P
    }
}


