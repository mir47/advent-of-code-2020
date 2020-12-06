package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day5Test {

    private val dayFive = Day5()

    @Test
    fun testPartOne() {
        assertThat(dayFive.partOne(), `is`(820))
    }

    @Test
    fun testPartTwo() {
        assertThat(dayFive.partTwo(), `is`(""))
    }
}
