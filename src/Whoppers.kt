package Classes

class Buy() {
    fun set(operation: Whopper) {
        operation.set()
    }
    fun one(operation:Whopper) {
        operation.one()
    }
    fun name(operation: Whopper) {
        operation.name()
    }
    fun displayInfo(operation: Whopper) {
        operation.displayInfo()
    }

}
abstract class Whopper() {
    abstract var name:String
    open var bun = "basic bun"
    open var patty = "beef patty"
    open var vegetable = "tomato, lettuce, onion, cucumber"
    open var sauce = "none"
    open var price = 8000
    open var set = price+2500


    open fun name() {
        println("[$name]를 구매하시겠습니까?\n"
                +"1. 단품 구매하기   | $price  | \n"
                +"2. 세트 구매하기   | ${price+2500} | \n"
                +"3. 구성 확인하기   | \n"
                +"0. 뒤로가기       | 이전으로 돌아가기\n")
    }
    fun one() {
        println("가격 : ${price}원\n"
                +"1.구매 0. 뒤로 가기")
    }
    fun set() {
        println("가격 : ${set}원\n"
                +"1.구매 0. 뒤로 가기")

    }
    open fun displayInfo() {
        println("번   : ${bun}\n"+
                "패티 : ${patty}\n"+
                "야채 : ${vegetable}\n"+
                "소스 : ${sauce}\n"+
                "0. 뒤로가기")
    }
}

class Basic() : Whopper() {
    override var name = "와퍼"
    override var sauce = "ketchup"

}

class Bulg() : Whopper() {
    override var name = "불고기 와퍼"
    override var vegetable = "lettuce, onion"
    override var sauce = "Bulgogi sauce and mayonnaise"
}

class Mons() : Whopper() {
    override var name = "몬스터 와퍼"
    override var patty = "beef and chicken patty, bacon"
    override var sauce = "diablo sauce"
    override var price = 10200
    override var set = price+2500
}

class Cube() : Whopper() {
    override var name = "큐브 스테이크 와퍼"
    override var bun = "egg bun"
    override var patty = "cube steak and beef patty"
    override var sauce = "steak sauce and mayonnaise"
    override var price = 9900
    override var set = price+2500
}