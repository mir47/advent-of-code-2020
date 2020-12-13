package days

class Day13 : Day(13) {

    private val schedule = inputList[1].split(',').map { if (it == "x") -1 else it.toInt() }

    override fun partOne(): Any {
        val arrival = inputList[0].toInt()
        val result = schedule
            .filter { it != -1 }
            .map { Pair(it, arrival + it - (arrival % it)) }
            .minByOrNull { it.second } ?: Pair(0,0)
        return result.first * (result.second - arrival)
    }

    override fun partTwo(): Any {
        val n = mutableListOf<Long>()
        val a = mutableListOf<Long>()
        for ((i, time) in schedule.withIndex()) {
            if (time > 0) {
                n.add(time.toLong())
                a.add((time - i).toLong())
            }
        }
        return chineseRemainder(n.toLongArray(), a.toLongArray())
    }

    // TIL: Chinese remainder theorem, thanks to:
    // https://github.com/agrison/advent-of-code-2020/blob/master/src/main/kotlin/days/Day13.kt
    // https://rosettacode.org/wiki/Chinese_remainder_theorem#Kotlin
    private fun chineseRemainder(n: LongArray, a: LongArray): Long {
        val prod: Long = n.fold(1) { acc, i -> acc * i }
        var sum = 0L
        for (i in n.indices) {
            val p = prod / n[i]
            sum += a[i] * multInv(p, n[i]) * p
        }
        return sum % prod
    }

    /* returns x where (a * x) % b == 1 */
    private fun multInv(a: Long, b: Long): Long {
        if (b == 1L) return 1L
        var aa = a
        var bb = b
        var x0 = 0L
        var x1 = 1L
        while (aa > 1) {
            val q = aa / bb
            var t = bb
            bb = aa % bb
            aa = t
            t = x0
            x0 = x1 - q * x0
            x1 = t
        }
        if (x1 < 0) x1 += b
        return x1
    }
}
