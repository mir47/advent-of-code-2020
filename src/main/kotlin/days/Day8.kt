package days

class Day8 : Day(8) {

    override fun partOne(): Any {
        val steps = getSanitizedInput()
        var acc = 0
        var idx = 0
        while (true) {
            val step = steps[idx]
            if (step.visited) {
                break
            } else {
                idx += when (step.instruction) {
                    "acc" -> { acc += step.value; 1 }
                    "jmp" -> step.value
                    else -> 1
                }
                step.visited = true
            }
        }
        return acc
    }

    override fun partTwo(): Any {
        val steps = getSanitizedInput()
        var swapIdx = 0
        var first = true

        while (true) {
            if (!first) {
                val step = steps[swapIdx]
                if (step.instruction == "jmp") {
                    step.instruction = "nop"
                } else if (step.instruction == "nop") {
                    step.instruction = "jmp"
                }
            }

            for (i in swapIdx+1 until steps.size-1) {
                val step = steps[i]
                if (step.instruction == "jmp") {
                    step.instruction = "nop"
                    swapIdx = i
                    break
                } else if (step.instruction == "nop") {
                    step.instruction = "jmp"
                    swapIdx = i
                    break
                }
            }

            var acc = 0
            var idx = 0
            while (true) {
                if (idx == steps.size) {
                    return acc
                } else if (steps[idx].visited) {
                    break
                } else {
                    val step = steps[idx]
                    idx += when (step.instruction) {
                        "acc" -> { acc += step.value; 1 }
                        "jmp" -> step.value
                        else -> 1
                    }
                    step.visited = true
                }
            }

            steps.forEach { it.visited = false }

            first = false
        }
    }

    private fun getSanitizedInput(): List<Step> {
        return inputList.map {
            val split = it.split(" ")
            Step(split[0], split[1].toInt())
        }
    }
}

data class Step(var instruction: String, val value: Int, var visited: Boolean = false)
