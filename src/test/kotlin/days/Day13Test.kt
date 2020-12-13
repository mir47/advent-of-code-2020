package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day13Test {

    private val day = Day13()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(295))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(1068781L))
    }
}
