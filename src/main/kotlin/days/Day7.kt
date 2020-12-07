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

    private fun getContainers(allBags: Map<String, String>, bags: Set<String>): Set<String> {
        val containers = mutableSetOf<String>()
        bags.forEach { bag ->
            val set = allBags.filter { it.value.contains(bag) }.map { it.key }.toSet()
            containers.addAll(set)
            containers.addAll(getContainers(allBags, set))
        }
        return containers
    }

    private fun getContains(allBags: Map<String, String>, bag: String): Int {
        var count = 0
        allBags[bag]?.split(",")
            ?.map { it.replace(",", "").trim().split(" ") }
            ?.filter { it[0] != "no" }
            ?.forEach {
                val bagCount = it[0].toInt()
                val bagPrefix = it[1]
                val bagSuffix = it[2]
                count += bagCount + (bagCount * getContains(allBags, "$bagPrefix $bagSuffix"))
            }
        return count
    }
}