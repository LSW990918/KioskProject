package Classes

fun main() {

    val foods = arrayListOf<String>()

    var bask = " 와퍼 | 8000 | "
    foods.add(bask)
    foods.add(bask)
    foods.add(bask)
    foods.add(bask)


    var food = Shopping("와퍼", 8000)

    val food2 = Shopping("와퍼세트", 10500)

    val food3 = Shopping("불고기와퍼", 8500)





    for (i in 0 until foods.size) {
        println("${i + 1}. ${foods[i]} ")
    }

}

private fun <K, V> MutableMap<K, V>.set(key: Pair<String, Int>) {

}
