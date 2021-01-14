package main.kt.engine

import main.kt.model.Chromosome
import main.kt.model.Gene
import main.kt.model.Population


fun main() {
    GeneticAlgorithmTest().runGATest()
}

internal class GeneticAlgorithmTest {

    fun runGATest() {

        // GIVEN

        val testAlgorithm = GeneticAlgorithm(
            GAParameters(
                populationFactory = TestPopulationFactory(),
                stopCondition = TestStopCondition(),
                selectionOperator = { testSelection() },
                crossoverOperator = { testCrossover() },
                mutationOperator = { testMutation() },
            )
        )

        // WHEN
        val result = testAlgorithm.runGA()
        result.findBest()

        // THEN
        println(result.increment)
        /*
        Expected output :
            Test population generated
            selection done
            crossover done
            mutation done
            3
         */
    }
}


class TestGene() : Gene()
class TestChromosome() : Chromosome(listOf(TestGene())) {
    override fun computeFitness(): Int = genes.size
}

class TestPopulation(var increment: Int = 0) : Population(
    listOf(TestChromosome())
)

fun TestPopulation.testSelection(): TestPopulation {
    println("selection done")
    return TestPopulation(++increment)
}

fun TestPopulation.testCrossover(): TestPopulation {
    println("crossover done")
    return TestPopulation(++increment)

}

fun TestPopulation.testMutation(): TestPopulation {
    println("mutation done")
    return TestPopulation(++increment)
}

class TestPopulationFactory : Population.PopulationFactory<TestPopulation>() {
    override fun generatePopulation(): TestPopulation {
        println("Test population generated")
        return TestPopulation()
    }
}

class TestStopCondition(private val limit: Int = 1) : StopCondition {
    private var increment = 0
    override fun isMet(): Boolean = increment++ == limit
}
