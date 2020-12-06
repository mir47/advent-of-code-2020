package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day6Test {

    private val daySix = Day6()

    @Test
    fun testPartOne() {
        assertThat(daySix.partOne(), `is`(11))
    }

    @Test
    fun testPartTwo() {
        assertThat(daySix.partTwo(), `is`(6))
    }
}
