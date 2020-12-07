package days

class Day7 : Day(7) {

    override fun partOne() = getContainers(getSanitizedInput(), setOf("shiny gold")).size

    override fun partTwo() = getContains(getSanitizedInput(), "shiny gold")

    private fun getSanitizedInput(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        inputList.map {
            val ar = it.split("bags contain")
            map.put(ar[0].trim(), ar[1].trim())
        }
        return map
    }

    private fun getContainers(map: Map<String, String>, bags: Set<String>): Set<String> {
        val containers = mutableSetOf<String>()
        bags.forEach { bag ->
            val set = map.filter { it.value.contains(bag) }.map { it.key }.toSet()
            containers.addAll(set)
            containers.addAll(getContainers(map, set))
        }
        return containers
    }

    private fun getContains(map: Map<String, String>, bag: String): Int {
        var count = 0
        map[bag]?.split(",")
            ?.map { it.replace(",","").trim().split(" ") }
            ?.forEach {
                if (it[0] != "no") {
                    count += it[0].toInt() + (it[0].toInt() * getContains(map, "${it[1]} ${it[2]}"))
                }
            }
        return count
    }
}