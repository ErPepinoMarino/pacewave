package com.erpepino.pacewave.domain

/** A positive running pace, represented as seconds required to cover one kilometre. */
@JvmInline
value class Pace private constructor(val secondsPerKilometer: Int) {
    val metersPerSecond: Double
        get() = METERS_PER_KILOMETER / secondsPerKilometer

    companion object {
        private const val METERS_PER_KILOMETER = 1_000.0

        fun ofSecondsPerKilometer(value: Int): Pace {
            require(value > 0) { "Pace must be greater than zero seconds per kilometre." }
            return Pace(value)
        }
    }
}
