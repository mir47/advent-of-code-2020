package days

class Day5 : Day(5) {

    override fun partOne() = seats().maxOrNull() ?: 0

    override fun partTwo(): Any {
        var id = 0
        val s = seats()
        val min = s.minOrNull() ?: 0
        val max = s.maxOrNull() ?: 0
        for (i in min..max) {
            if (!s.contains(i)) id = i
        }
        return id
    }

    private fun seats() = inputList.map { pass ->
        val row = pass.substring(0, 7).map { if (it == 'F') '0' else '1' }.joinToString("")
        val rowValue = Integer.parseInt(row, 2)

        val col = pass.substring(7).map { if (it == 'L') '0' else '1' }.joinToString("")
        val colValue = Integer.parseInt(col, 2)

        rowValue * 8 + colValue
    }
}