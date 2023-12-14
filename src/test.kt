package Classes

fun main() {

    val foods = arrayListOf<String>()

    var bask = " 와퍼 | 8000 | "
    foods.add(bask)
    foods.add(bask)
    foods.add(bask)
    foods.add(bask)


    for (i in 0 until foods.size) {
        println("${i + 1}. ${foods[i]} ")
    }
}