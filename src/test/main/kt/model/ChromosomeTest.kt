package main.kt.model

fun main() {
    ChromosomeTest().computeFitnessTest()
}

internal class ChromosomeTest {

    fun computeFitnessTest() {

        // GIVEN
        class TestChromosome(genes: List<Gene>) : Chromosome(genes) {
            var increment = 0
            override fun computeFitness(): Int = increment++
        }

        val testChromosome = TestChromosome(listOf())

        // WHEN
        testChromosome.computeFitness()
        testChromosome.computeFitness()
        testChromosome.computeFitness()

        // THEN
        print(testChromosome.increment)

        /*
            Expected output : 3
        */
    }

}