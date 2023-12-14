package Classes

class Chic {
    fun set(operation: Chickenburger) {
        operation.set()
    }
    fun one(operation:Chickenburger) {
        operation.one()
    }
    fun name(operation: Chickenburger) {
        operation.name()
    }
    fun displayInfo(operation: Chickenburger) {
        operation.displayInfo()
    }

}
abstract class Chickenburger() {
    abstract var name:String
    open var bun = "basic bun"
    open var patty = "chicken patty"
    open var vegetable = "lettuce"
    open var sauce = "none"
    open var price = 6600
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
                +"1.장바구니에 추가 0. 뒤로 가기")
    }
    fun set() {
        println("가격 : ${set}원\n"
                +"1.장바구니에 추가 0. 뒤로 가기")

    }
    open fun displayInfo() {
        println("번   : ${bun}\n"+
                "패티 : ${patty}\n"+
                "야채 : ${vegetable}\n"+
                "소스 : ${sauce}\n"+
                "0. 뒤로가기")
    }
}

class Base() : Chickenburger() {
    override var name = "치킨 버거"
    override var sauce = "mustard"

}

class Barb() : Chickenburger() {
    override var name = "바베큐 치킨 버거"
    override var vegetable = "lettuce"
    override var sauce = "Barbecue and mayonnaise sauce"
}

class Long() : Chickenburger() {
    override var name = "롱치킨 버거"
    override var patty = "long chicken patty"
    override var sauce = "mustard"
    override var price = 8100
    override var set = price+2500
}

class King() : Chickenburger() {
    override var name = "치킨킹"
    override var bun = "egg bun"
    override var patty = "chicken patty"
    override var sauce = "mustard and hot sauce"
    override var price =9900
    override var set = price+2500
}
