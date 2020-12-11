package days

class Day11 : Day(11) {

    override fun partOne(): Any {
        var seatState = inputList.toMutableList()
        val seatStateNew = inputList.toMutableList()
        var changed = true
        while (changed) {
            changed = false
            seatState.forEachIndexed { rowIndex, row ->
                var builder = StringBuilder()
                row.forEachIndexed { colIndex, seat ->
                    if (seat == 'L' && countAdjacentOccupied(seatState, rowIndex, colIndex) == 0) {
                        builder.append("#")
                        changed = true
                    } else if (seat == '#' && countAdjacentOccupied(seatState, rowIndex, colIndex) >= 4) {
                        builder.append("L")
                        changed = true
                    } else {
                        builder.append(seatState[rowIndex][colIndex])
                    }
                }
                seatStateNew[rowIndex] = builder.toString()
//                println(seatStateNew[rowIndex])
            }
            seatState = seatStateNew.toMutableList()
//            println()
        }

        var count = 0
        seatState.forEach { row ->
            row.forEach { seat ->
                if (seat == '#') count++
            }
        }
        return count
    }

    override fun partTwo(): Any {
        return -1
    }

    private fun countAdjacentOccupied(seats: List<String>, y: Int, x: Int): Int {
        var adj = ""
        seats.getOrNull(y-1)?.let {
            if (x > 0) adj += it[x-1]
            adj += it[x]
            if (x < it.length-1) adj += it[x+1]
        }
        seats.getOrNull(y)?.let {
            if (x > 0) adj += it[x-1]
            if (x < it.length-1) adj += it[x+1]
        }
        seats.getOrNull(y+1)?.let {
            if (x > 0) adj += it[x-1]
            adj += it[x]
            if (x < it.length-1) adj += it[x+1]
        }
        return adj.count { it == '#' }
    }
}