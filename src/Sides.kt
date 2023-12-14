package Kiosk

class Buyside() {
    fun up(operation: Side) {
        operation.up()
    }
    fun one(operation:Side) {
        operation.one()
    }
    fun name(operation: Side) {
        operation.name()
    }
    fun displayInfo(operation: Side) {
        operation.displayInfo()
    }

}
abstract class Side() {
    abstract var name:String
    open var from = ""
    open var price = 2000
    open var up = price+1200


    open fun name() {
        println("[$name]를 구매하시겠습니까?\n"
                +"1. 구매하기 (M)       | $price  | \n"
                +"2. 구매하기 (L)       | ${price+1200} | \n"
                +"3. 원산지 확인하기     | \n"
                +"0. 뒤로가기           | 이전으로 돌아가기\n")
    }
    fun one() {
        println("가격 : ${price}원\n"
                +"1.장바구니에 추가 0. 뒤로 가기")
    }
    fun up() {
        println("가격 : ${up}원\n"
                +"1.장바구니에 추가 0. 뒤로 가기")
    }
    open fun displayInfo() {
        println("${name} : ${from}\n"+
                "0. 뒤로가기")
    }
}

class fries() : Side() {
    override var name = "감자튀김"
    override var from = "American potato"
}

class ch() : Side() {
    override var name = "치즈스틱"
    override var from = "Italian cheese"
}

class on() : Side() {
    override var name = "어니언 링"
    override var from = "Korean onion"
    override var price = 3000
    override var up = price+1200
}

class ng() : Side() {
    override var name = "너겟킹"
    override var from = "Korean chicken"
    override var price = 3000
    override var up = price+1200
}