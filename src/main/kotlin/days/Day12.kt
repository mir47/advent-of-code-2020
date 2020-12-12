package days

import kotlin.math.abs

class Day12 : Day(12) {

    override fun partOne(): Any {
        var angle = 0
        var x = 0
        var y = 0
        inputList.map { Pair(it.substring(0, 1), it.substring(1).toInt()) }.forEach {
            when (it.first) {
                "N" -> { y -= it.second }
                "S" -> { y += it.second }
                "E" -> { x += it.second }
                "W" -> { x -= it.second }
                "L" -> {
                    angle += it.second
                    angle %= 360
                }
                "R" -> {
                    angle += 360 - it.second
                    angle %= 360
                }
                "F" -> {
                    when (angle) {
                        90 -> { y -= it.second }
                        270 -> { y += it.second }
                        0 -> { x += it.second }
                        180 -> { x -= it.second }
                    }
                }
            }
        }
        return abs(x) + abs(y)
    }

    override fun partTwo(): Any {
        var x = 0
        var y = 0
        var xw = 10
        var yw = -1
        inputList.map { Pair(it.substring(0, 1), it.substring(1).toInt()) }.forEach {
            when (it.first) {
                "N" -> { yw -= it.second }
                "S" -> { yw += it.second }
                "E" -> { xw += it.second }
                "W" -> { xw -= it.second }
                "L" -> {
                    when (it.second) {
                        90 -> {
                            yw = xw.also { xw = yw }
                            yw *= -1
                        }
                        180 -> {
                            xw *= -1
                            yw *= -1
                        }
                        270 -> {
                            yw = xw.also { xw = yw }
                            xw *= -1
                        }
                    }
                }
                "R" -> {
                    when (it.second) {
                        90 -> {
                            yw = xw.also { xw = yw }
                            xw *= -1
                        }
                        180 -> {
                            xw *= -1
                            yw *= -1
                        }
                        270 -> {
                            yw = xw.also { xw = yw }
                            yw *= -1
                        }
                    }
                }
                "F" -> {
                    (1..it.second).forEach { _ ->
                        x += xw
                        y += yw
                    }
                }
            }
        }
        return abs(x) + abs(y)
    }
}