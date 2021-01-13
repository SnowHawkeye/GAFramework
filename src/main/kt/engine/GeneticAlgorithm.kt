package main.kt.engine

import main.kt.model.Population

class GeneticAlgorithm<P : Population>(
    private val parameters: GAParameters<P>
) {

    fun run(): P {
        with(parameters) {
            val currentPopulation = populationFactory.generatePopulation()
            var result: P = currentPopulation
            while (!stopCondition.isMet()) {
                result = currentPopulation
                    .selectionOperator()
                    .crossoverOperator()
                    .mutationOperator()

            }
            return result
        }
    }
}
