package com.erpepino.pacewave.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PaceTest {
    @Test
    fun convertsMinutesPerKilometerToMetersPerSecond() {
        val pace = Pace.ofSecondsPerKilometer(300)

        assertEquals(3.3333333333333335, pace.metersPerSecond)
    }

    @Test
    fun rejectsZeroOrNegativePace() {
        assertFailsWith<IllegalArgumentException> { Pace.ofSecondsPerKilometer(0) }
        assertFailsWith<IllegalArgumentException> { Pace.ofSecondsPerKilometer(-1) }
    }
}
