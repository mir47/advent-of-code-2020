package days

class Day3 : Day(3) {
    override fun partOne(): Any {
        var r = 3
        var d = 1
        var x = 0
        var trees = 0
        inputList.forEachIndexed { i, row ->
            if (i % d == 0) {
                if (i != 0) {
                    x+=r
                    if (x >= row.length) {
                        x -= row.length
                    }
//                    println("x = $x")
                    if (row[x] == '#') {
                        trees++
                    }
                }
            }
        }
        return trees
    }

    override fun partTwo(): Any {
        var r = 1
        var d = 2
        var x = 0
        var trees = 0
        inputList.forEachIndexed { i, row ->
            if (i % d == 0) {
                if (i != 0) {
                    x+=r
                    if (x >= row.length) {
                        x -= row.length
                    }
//                    println("x = $x")
                    if (row[x] == '#') {
                        trees++
                    }
                }
            }
        }
        return trees
    }
}

// 1, 1 = 90
// 3, 1 = 278
// 5, 1 = 88
// 7, 1 = 98
// 1, 2 = 45
// multiplied = 9 709 761 600
