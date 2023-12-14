class BuyDrink() {
    fun set(operation: Drink) {
        operation.set()
    }
    fun set2(operation: Drink) {
        operation.set2()
    }
    fun one(operation: Drink) {
        operation.one()
    }
    fun name(operation: Drink) {
        operation.name()
    }


}
abstract class Drink() {
    abstract var name: String
    open var price = 1600
    open var set = price + 500
    open var set2 = set + 500


    open fun name() {
        println(
            "[$name]를 구매하시겠습니까?\n"
                    + "1. M 구매하기   | $price  | \n"
                    + "2. L 구매하기   | ${set} | \n"
                    + "3. XL 구매하기   | ${set2} | \n"
                    + "0. 뒤로가기       | 이전으로 돌아가기\n"
        )
    }


    fun one() {
        println(
            "가격 : ${price}원\n"
                    + "1.구매 0. 뒤로 가기"
        )
    }

    fun set() {
        println(
            "가격 : ${set}원\n"
                    + "1.구매 0. 뒤로 가기"
        )

    }

    fun set2() {
        println(
            "가격 : ${set2}원\n"
                    + "1.구매 0. 뒤로 가기"
        )

    }
}


class Coca() : Drink() {
    override var name = "Cocacola"
}

class Spr() : Drink() {
    override var name = "Sprite"
}

class Wel() : Drink() {
    override var name = "Welches"
}

class Mtndwe() : Drink() {
    override var name = "Mountain Dwe"
}
