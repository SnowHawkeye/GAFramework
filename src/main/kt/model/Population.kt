package main.kt.model

abstract class Population {

    abstract class PopulationFactory<P: Population> {
        abstract fun generatePopulation(): P
    }
}


