package days

import java.lang.System.lineSeparator

class Day4 : Day(4) {
    override fun partOne(): Any {
        val criteria = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

        val passports = inputString.split(lineSeparator() + lineSeparator())
            .map { it.replace(lineSeparator(), " ") }

        var p1 = 0
        passports.forEach { if (criteria.all { c -> it.contains(c) }) p1++ }
        return p1
    }

    override fun partTwo(): Any {
        var p2 = 0
        val passports = inputString.split(lineSeparator() + lineSeparator())
            .map { it.replace(lineSeparator(), " ") }

        passports.forEach { p ->
            var c = 0
            p.split(" ").forEach { field ->
                val f = field.split(":")
                when (f[0]) {
                    "byr" -> if (f[1].toInt() in (1920..2002)) c++
                    "iyr" -> if (f[1].toInt() in (2010..2020)) c++
                    "eyr" -> if (f[1].toInt() in (2020..2030)) c++
                    "hgt" -> {
                        if (f[1].contains("cm")) {
                            val h = f[1].replace("cm", "")
                            if (h.toInt() in (150..193)) c++
                        } else if (f[1].contains("in")) {
                            val h = f[1].replace("in", "")
                            if (h.toInt() in (59..76)) c++
                        }
                    }
                    "hcl" -> if (f[1].matches("#[0-9a-f]{6}".toRegex())) c++
                    "ecl" -> if (f[1] in (listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth"))) c++
                    "pid" -> if (f[1].matches("\\d{9}".toRegex())) c++
                }
            }
            if (c == 7) p2++
        }
        return p2
    }
}