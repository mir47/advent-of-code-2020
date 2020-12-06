package days

import java.lang.System.lineSeparator

class Day6 : Day(6) {

    override fun partOne(): Any {
        var c = 0
        val groups = inputString.split(lineSeparator() + lineSeparator())
            .map { it.replace(lineSeparator(), "") }
        groups.forEach { c += it.toSet().count() }
        return c
    }

    override fun partTwo(): Any {
        var c = 0
        val groups = inputString.split(lineSeparator() + lineSeparator())
            .map { it.replace(lineSeparator(), " ") }
        groups.forEach { group ->
            group.replace(" ", "").toSet().forEach { answer ->
                if (group.split(" ").all { it.contains(answer) }) c++
            }
        }
        return c
    }
}