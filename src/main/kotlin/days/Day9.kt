package days

class Day9 : Day(9) {

    override fun partOne() = findNumber(inputList.map { it.toLong() }).second

    override fun partTwo(): Any {
        val input = inputList.map { it.toLong() }
        val invalid = findNumber(input)
        for (i in 0 until invalid.first-1) {
            var min = invalid.second
            var max = 0L
            var sum = 0L
            var idx = i
            while (sum < invalid.second) {
                sum += input[idx]
                min = minOf(min, input[idx])
                max = maxOf(max, input[idx])
                idx++
            }
            if (sum == invalid.second) return min + max
        }
        return -1
    }

    private fun findNumber(input: List<Long>): Pair<Int, Long> {
        val preamble = 25
        for (i in preamble until input.size-1) {
            var found = false
            for (j in i-preamble until i-1) {
                for (k in j+1 until i) {
                    if (input[j] != input[k] && input[i] == input[j] + input[k]) {
                        found = true
                    }
                }
            }
            if (!found) return Pair(i, input[i])
        }
        return Pair(-1, -1)
    }
}