package days

class Day1 : Day(1) {
    override fun partOne(): Any {
        var s = ""
        for (i in 0 until inputList.lastIndex-2) {
            for (j in i+1 until inputList.lastIndex) {
                if (inputList[i].toInt() + inputList[j].toInt() == 2020) {
                    s = "${inputList[i].toInt() * inputList[j].toInt()}"
                }
            }
        }
        return s
    }

    override fun partTwo(): Any {
        var s = ""
        for (i in 0 until inputList.lastIndex-2) {
            for (j in i+1 until inputList.lastIndex) {
                for (k in j+1 until inputList.lastIndex) {
                    if (inputList[i].toInt() + inputList[j].toInt() + inputList[k].toInt() == 2020) {
                        s = "${inputList[i].toInt() * inputList[j].toInt() * inputList[k].toInt()}"
                    }
                }
            }
        }
        return s
    }
}
