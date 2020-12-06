package days

class Day2 : Day(2) {
    override fun partOne(): Any {
        return countValid(inputList) { l, r, letter, pwd ->
            pwd.count { letter == it } in (l..r)
        }
    }

    override fun partTwo(): Any {
        return countValid(inputList) { l, r, letter, pwd ->
            (pwd[l-1] == letter && pwd[r-1] != letter) || (pwd[r-1] == letter && pwd[l-1] != letter)
        }
    }

    private fun countValid(passwords: List<String>, policy: (a: Int, b: Int, letter: Char, pwd: String) -> Boolean): Int {
        val regex = Regex("(\\d+)-(\\d+) ([a-z]): ([a-z]+)")
        return passwords.count {
            val (l, r, letter, pwd) = regex.find(it)!!.destructured
            policy(l.toInt(), r.toInt(), letter[0], pwd)
        }
    }
}
