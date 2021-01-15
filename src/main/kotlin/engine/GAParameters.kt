package engine

import model.Population

data class GAParameters<P : Population>(
    val populationFactory: Population.PopulationFactory<P>,
    val stopCondition: StopCondition,
    val selectionOperator: P.() -> P,
    val crossoverOperator: P.() -> P,
    val mutationOperator: P.() -> P,
)

interface StopCondition {
    fun isMet(): Boolean
}