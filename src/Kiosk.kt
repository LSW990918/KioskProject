@file:Suppress("UNREACHABLE_CODE")

package Classes

import Kiosk.*

fun String.isNumeric(): Boolean {
    return try {
        this.toInt()
        true
    } catch (e: Exception) {
        false
    }
}

fun main() {
    val basketlist = arrayListOf<String>()
    var cost = 0
    var money = (20000..50000).random()

    println("초기금액 ${money}원이 지급되었습니다.")
    println("버거킹에 오신것을 환영합니다!")
    while (true) {
        println(
            "[BURGURKING MENU]\n"
                    + "1. Whopper         | 순 쇠고기 패티에 싱싱한 야채가 가득~\n"
                    + "2. Chicken burger  | 에그번과 고소한 소스, 치킨패티의 만남! \n"
                    + "3. Side            | 신선한 재료만을 엄선해서 버거킹만의 비법으로 바삭하게!\n"
                    + "4. Drink           | 탄산으로 더 짜릿하게!\n"
                    + "5. 장바구니         | 장바구니 확인하기\n"
                    + "0. 종료            | 키오스크 종료\n"
        )
        val main = readln()
        if (!main.isNumeric()) {
            System.err.println("메뉴 입력은 숫자만 가능합니다")
            continue
        }
        when (main.toInt()) {
            1 -> {
                while (true){
                    println("[Whopper MENU]\n"
                            + "1. 와퍼               | W  8.0 | 버거킹의 대표 메뉴 쇠고기패티 와퍼!\n"
                            + "2. 불고기 와퍼         | W  8.0 | 불맛 가득 쇠고기 패티가 들어간 와퍼에 달콤한 불고기 소스까지!\n"
                            + "3. 몬스터 와퍼         | W 10.2 | 기본재료에 치킨패티, 베이컨, 화끈한 디아블로 소스를 더한 와퍼!\n"
                            + "4. 큐브 스테이크 와퍼   | W  9.9 | 고기에 고기를 쌓아만든 고기 맛의 정점\n"
                            + "0. 뒤로가기            | 전체메뉴로 돌아가기\n")
                    var ww = readln()  //와퍼 선택하기
                    if (!ww.isNumeric()) {
                        System.err.println("입력은 숫자만 가능합니다")
                        continue }
                    val buy = Buy()  //buy = Buy 클래스
                    when (ww.toInt()) {
                        1 -> { //1번 선택시 기본 와퍼
                            while (true) {
                                var w = Basic()  //w = 기본 와퍼
                                buy.name(Basic()) //해당 와퍼 소개 내용
                                val b = readln()
                                when (b.toInt()) {
                                    1 -> {
                                        buy.one(Basic()) //단품 구매창
                                        cost = cost + w.price
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                var mon = money - cost
                                                if (mon >= 0) {
                                                    var basket = " ${w.name} | ${w.price} | "
                                                    basketlist.add(basket)
                                                    println("장바구니에 ${w.name} 추가 완료!\n"
                                                            +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                    continue
                                                } else {
                                                    cost -= w.price
                                                    println("잔액이 부족합니다.")
                                                }
                                                continue
                                            }
                                            0 -> {
                                                continue
                                            }
                                        }
                                    }
                                    2 -> {
                                        buy.set(Basic()) //세트 구매창
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                cost += w.set
                                                var mon = money - cost
                                                if (mon >= 0) {
                                                    var basket = " ${w.name}세트 | ${w.set} | "
                                                    basketlist.add(basket)
                                                    println("장바구니에 ${w.name} 세트 추가 완료!\n"
                                                            +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                    continue
                                                } else {
                                                    cost -= w.set
                                                    println("잔액이 부족합니다.")
                                                }
                                                continue
                                            }
                                            0 -> {
                                                continue
                                            }
                                        }
                                    }
                                    3 -> {
                                        buy.displayInfo(Basic())
                                        var purchase = readln()
                                        if (purchase.toInt() == 0) {
                                            continue
                                        }
                                    }
                                    0 -> {
                                        break
                                    }
                                }
                            }
                        }
                        2 -> { // 불고기와퍼
                            while (true) {
                                var w = Bulg()  //w = 기본 와퍼
                                buy.name(Bulg()) //해당 와퍼 소개 내용
                                val b = readln()
                                when (b.toInt()) {
                                    1 -> {
                                        buy.one(Bulg()) //단품 구매창
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                cost += w.price
                                                var mon = money - cost
                                                if (mon >= 0) {
                                                    var basket = " ${w.name} | ${w.price} | "
                                                    basketlist.add(basket)
                                                    println("장바구니에 ${w.name} 추가 완료!\n"
                                                            +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                    continue
                                                } else {
                                                    cost -= w.price
                                                    println("잔액이 부족합니다.")
                                                }
                                                continue
                                            }
                                            0 -> {
                                                continue
                                            }
                                        }
                                    }
                                    2 -> {
                                        buy.set(Bulg()) //세트 구매창
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                cost += w.set
                                                var mon = money - cost
                                                if (mon >= 0) {
                                                    var basket = " ${w.name}세트 | ${w.set} | "
                                                    basketlist.add(basket)
                                                    println("장바구니에 ${w.name} 세트 추가 완료!\n"
                                                            +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                    continue
                                                } else {
                                                    cost -= w.set
                                                    println("잔액이 부족합니다.")
                                                }
                                                continue
                                            }
                                            0 -> {
                                                continue
                                            }
                                        }
                                    }
                                    3 -> {
                                        buy.displayInfo(Bulg())
                                        var purchase = readln()
                                        if (purchase.toInt() == 0) {
                                            continue
                                        }
                                    }
                                    0 -> {
                                        break
                                    }
                                }
                            }
                        }
                        3 -> { // 몬스터와퍼
                            while (true) {
                                var w = Mons()  //w = 기본 와퍼
                                buy.name(Mons()) //해당 와퍼 소개 내용
                                val b = readln()
                                when (b.toInt()) {
                                    1 -> {
                                        buy.one(Mons()) //단품 구매창
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                cost += w.price
                                                var mon = money - cost
                                                if (mon >= 0) {
                                                    var basket = " ${w.name} | ${w.price} | "
                                                    basketlist.add(basket)
                                                    println("장바구니에 ${w.name} 추가 완료!\n"
                                                            +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                    continue
                                                } else {
                                                    cost -= w.price
                                                    println("잔액이 부족합니다.")
                                                }
                                                continue
                                            }
                                            0 -> {
                                                continue
                                            }
                                        }
                                    }
                                    2 -> {
                                        buy.set(Mons()) //세트 구매창
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                cost += w.set
                                                var mon = money - cost
                                                if (mon >= 0) {
                                                    var basket = " ${w.name}세트 | ${w.set} | "
                                                    basketlist.add(basket)
                                                    println("장바구니에 ${w.name} 세트 추가 완료!\n"
                                                            +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                    continue
                                                } else {
                                                    cost -= w.set
                                                    println("잔액이 부족합니다.")
                                                }
                                                continue
                                            }
                                            0 -> {
                                                continue
                                            }
                                        }
                                    }
                                    3 -> {
                                        buy.displayInfo(Mons())
                                        var purchase = readln()
                                        if (purchase.toInt() == 0) {
                                            continue
                                        }
                                    }
                                    0 -> {
                                        break
                                    }
                                }
                            }
                        }
                        4 -> { // 큐브스테이크와퍼
                            while (true) {
                                var w = Cube()  //w = 기본 와퍼
                                buy.name(Cube()) //해당 와퍼 소개 내용
                                val b = readln()
                                when (b.toInt()) {
                                    1 -> {
                                        buy.one(Cube()) //단품 구매창
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                cost += w.price
                                                var mon = money - cost
                                                if (mon >= 0) {
                                                    var basket = " ${w.name} | ${w.price} | "
                                                    basketlist.add(basket)
                                                    println("장바구니에 ${w.name} 추가 완료!\n"
                                                            +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                    continue
                                                } else {
                                                    cost -= w.price
                                                    println("잔액이 부족합니다.")
                                                }
                                                continue
                                            }
                                            0 -> {
                                                continue
                                            }
                                        }
                                    }
                                    2 -> {
                                        buy.set(Cube()) //세트 구매창
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                cost += w.set
                                                var mon = money - cost
                                                if (mon >= 0) {
                                                    var basket = " ${w.name}세트 | ${w.set} | "
                                                    basketlist.add(basket)
                                                    println("장바구니에 ${w.name} 세트 추가 완료!\n"
                                                            +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                    continue
                                                } else {
                                                    cost -= w.set
                                                    println("잔액이 부족합니다.")
                                                }
                                                continue
                                            }
                                            0 -> {
                                                continue
                                            }
                                        }
                                    }
                                    3 -> {
                                        buy.displayInfo(Cube())
                                        var purchase = readln()
                                        if (purchase.toInt() == 0) {
                                            continue
                                        }
                                    }
                                    0 -> {
                                        break
                                    }
                                }
                            }
                        }
                        0 -> {
                            break
                        }
                    }
                }
            }
            //치킨 버거
            2 -> {

            }
            //사이드
            3 -> {
                while (true){
                    println ("[Side MENU]\n"
                    +"1. 감자튀김            | 세계최고의 감자만 엄선해서 버거킹만의 비법으로 바삭하게!\n"
                    +"2. 치즈스틱            | 진하고 고소한 자연 모짜렐라가 가득한 치즈스틱!\n"
                    +"3. 어니언 링           | 더 바삭하게 한 입에 쏙!\n"
                    +"4. 너겟킹              | 바삭~ 촉촉~ 한입에 쏙 부드러운 너겟킹\n"
                    +"0. 뒤로가기            | 전체메뉴로 돌아가기\n")
                var sd = readln()
                val buy = Buyside()
                when (sd.toInt()) {
                    1 -> {while (true) {
                        var f = fries()  //f = 감자튀김
                        buy.name(fries()) //감자튀김 소개 내용
                        val b = readln()
                        when (b.toInt()) {
                            1 -> {
                                buy.one(fries()) //단품 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> { //결제
                                        cost += f.price
                                        var mon = money - cost
                                        if (mon >= 0) {
                                            var basket = " ${f.name}(M) | ${f.price} | "
                                            basketlist.add(basket)
                                            println("장바구니에 ${f.name}(M) 추가 완료!\n"
                                                    +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                            continue
                                        } else {
                                            cost -= f.price
                                            println("잔액이 부족합니다.")
                                        }
                                        continue
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            2 -> {
                                buy.up(fries()) //사이즈업 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> { //결제
                                        cost += f.up
                                        var mon = money - cost
                                        if (mon >= 0) {
                                            var basket = " ${f.name}(L) | ${f.up} | "
                                            basketlist.add(basket)
                                            println("장바구니에 ${f.name}(L) 추가 완료!\n"
                                                    +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                            continue
                                        } else {
                                            cost -= f.up
                                            println("잔액이 부족합니다.")
                                        }
                                        continue
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            3 -> {
                                buy.displayInfo(fries())
                                var purchase = readln()
                                if (purchase.toInt() == 0) {
                                    continue
                                }
                            }
                            0 -> {
                                break
                            }
                        }
                    }
                    }
                    2 -> {while (true) {
                        var cz = ch()  //cz = 치즈
                        buy.name(ch()) //감자튀김 소개 내용
                        val b = readln()
                        when (b.toInt()) {
                            1 -> {
                                buy.one(ch()) //단품 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> { //결제
                                        cost += cz.price
                                        var mon = money - cost
                                        if (mon >= 0) {
                                            var basket = " ${cz.name}(M) | ${cz.price} | "
                                            basketlist.add(basket)
                                            println("장바구니에 ${cz.name}(M) 추가 완료!\n"
                                                    +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                            continue
                                        } else {
                                            cost -= cz.price
                                            println("잔액이 부족합니다.")
                                        }
                                        continue
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            2 -> {
                                buy.up(ch()) //사이즈업 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> { //결제
                                        cost += cz.up
                                        var mon = money - cost
                                        if (mon >= 0) {
                                            var basket = " ${cz.name}(L) | ${cz.up} | "
                                            basketlist.add(basket)
                                            println("장바구니에 ${cz.name}(L) 추가 완료!\n"
                                                    +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                            continue
                                        } else {
                                            cost -= cz.up
                                            println("잔액이 부족합니다.")
                                        }
                                        continue
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            3 -> {
                                buy.displayInfo(ch())
                                var purchase = readln()
                                if (purchase.toInt() == 0) {
                                    continue
                                }
                            }
                            0 -> {
                                break
                            }
                        }
                    }
                    }
                    3 -> {while (true) {
                        var oo = on()  //oo = 어니언링
                        buy.name(on()) //어니언링 소개 내용
                        val b = readln()
                        when (b.toInt()) {
                            1 -> {
                                buy.one(on()) //단품 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> { //결제
                                        cost += oo.price
                                        var mon = money - cost
                                        if (mon >= 0) {
                                            var basket = " ${oo.name}(M) | ${oo.price} | "
                                            basketlist.add(basket)
                                            println("장바구니에 ${oo.name}(M) 추가 완료!\n"
                                                    +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                            continue
                                        } else {
                                            cost -= oo.price
                                            println("잔액이 부족합니다.")
                                        }
                                        continue
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            2 -> {
                                buy.up(on()) //사이즈업 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> { //결제
                                        cost += oo.up
                                        var mon = money - cost
                                        if (mon >= 0) {
                                            var basket = " ${oo.name}(L) | ${oo.up} | "
                                            basketlist.add(basket)
                                            println("장바구니에 ${oo.name}(L) 추가 완료!\n"
                                                    +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                            continue
                                        } else {
                                            cost -= oo.up
                                            println("잔액이 부족합니다.")
                                        }
                                        continue
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            3 -> {
                                buy.displayInfo(on())
                                var purchase = readln()
                                if (purchase.toInt() == 0) {
                                    continue
                                }
                            }
                            0 -> {
                                break
                            }
                        }
                    }
                    }
                    4 -> {while (true) {
                        var n = ng()  //n = 너겟
                        buy.name(ng()) //너겟 소개 내용
                        val b = readln()
                        when (b.toInt()) {
                            1 -> {
                                buy.one(ng()) //단품 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> { //결제
                                        cost += n.price
                                        var mon = money - cost
                                        if (mon >= 0) {
                                            var basket = " ${n.name}(M) | ${n.price} | "
                                            basketlist.add(basket)
                                            println("장바구니에 ${n.name}(M) 추가 완료!\n"
                                                    +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                            continue
                                        } else {
                                            cost -= n.price
                                            println("잔액이 부족합니다.")
                                        }
                                        continue
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            2 -> {
                                buy.up(ng()) //사이즈업 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> { //결제
                                        cost += n.up
                                        var mon = money - cost
                                        if (mon >= 0) {
                                            var basket = " ${n.name}(L) | ${n.up} | "
                                            basketlist.add(basket)
                                            println("장바구니에 ${n.name}(L) 추가 완료!\n"
                                                    +"추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                            continue
                                        } else {
                                            cost -= n.up
                                            println("잔액이 부족합니다.")
                                        }
                                        continue
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            3 -> {
                                buy.displayInfo(ng())
                                var purchase = readln()
                                if (purchase.toInt() == 0) {
                                    continue
                                }
                            }
                            0 -> {
                                break
                            }
                        }
                    }
                    }
                    0 -> {
                        break
                    }
                }
            }
        }
            //음료
            4 -> {
                while (true){
                    println("[SoftDrink MENU]\n"
                            + "1. CocaCola     | 햄버거의 영원한 단짝 코카콜라! \n"
                            + "2. Sprite       | 콜라의 라이벌 스프라이트 샤워하실래요?\n"
                            + "3. Welches      | 포도의 산뜻함과 청량감이 만났다. 웰치스!\n"
                            + "4. Mountain Dwe | 새로운 맛의 청량음료를 원한다면 골라라 마운틴듀!\n"
                            + "0. 뒤로가기       | 전체메뉴로 돌아가기\n"
                    )
                    var sd = readln()
                    when(sd.toInt()){
                         1 -> {
                             while(true){
                                 println("[CocaCola Size]\n"
                                         + "1. 사이즈(M)  | W 1.6\n"
                                         + "2. 사이즈(L)  | W 2.1\n"
                                         + "3. 사이즈(XL) | W 2.4\n"
                                         + "0. 뒤로가기    | 메뉴 선택으로 돌아가기\n")
                                 var sz = readln()
                                 when(sz.toInt()){
                                     1 -> {
                                         while (true) {
                                             println(
                                                 "[결제]\n"
                                                         + "1. 결제하기    | 음료 결제하기\n"
                                                         + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                             )
                                             var cc = readln()
                                             when(cc.toInt()){
                                                 1 -> {
                                                     println("완료")
                                                 }
                                                 0 -> {
                                                        break
                                                 }
                                             }

                                         }
                                     }
                                     2 -> {
                                         while (true) {
                                             println(
                                                 "[결제]\n"
                                                         + "1. 결제하기    | 음료 결제하기\n"
                                                         + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                             )
                                             var cc = readln()
                                             when(cc.toInt()){
                                                 1 -> {
                                                     println("완료")
                                                 }
                                                 0 -> {
                                                     break
                                                 }
                                             }

                                         }
                                     }
                                     3 -> {
                                         while (true) {
                                             println(
                                                 "[결제]\n"
                                                         + "1. 결제하기    | 음료 결제하기\n"
                                                         + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                             )
                                             var cc = readln()
                                             when(cc.toInt()){
                                                 1 -> {
                                                     println("완료")
                                                 }
                                                 0 -> {
                                                     break
                                                 }
                                             }

                                         }
                                     }
                                     0 -> {
                                         break
                                     }
                                 }
                             }
                         }
                        2 -> {
                            while(true){
                                println("[Sprite Size]\n"
                                        + "1. 사이즈(M)  | W 1.6\n"
                                        + "2. 사이즈(L)  | W 2.1\n"
                                        + "3. 사이즈(XL) | W 2.4\n"
                                        + "0. 뒤로가기    | 메뉴 선택으로 돌아가기\n")
                                var sz = readln()
                                when(sz.toInt()){
                                    1 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    2 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    3 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    0 -> {
                                        break
                                    }
                                }
                            }
                        }
                        3 -> {
                            while(true){
                                println("[Welches Size]\n"
                                        + "1. 사이즈(M)  | W 1.6\n"
                                        + "2. 사이즈(L)  | W 2.1\n"
                                        + "3. 사이즈(XL) | W 2.4\n"
                                        + "0. 뒤로가기    | 메뉴 선택으로 돌아가기\n")
                                var sz = readln()
                                when(sz.toInt()){
                                    1 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    2 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    3 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    0 -> {
                                        break
                                    }
                                }
                            }
                        }
                        4 -> {
                            while(true){
                                println("[Mountain Dwe Size]\n"
                                        + "1. 사이즈(M)  | W 1.6\n"
                                        + "2. 사이즈(L)  | W 2.1\n"
                                        + "3. 사이즈(XL) | W 2.4\n"
                                        + "0. 뒤로가기    | 메뉴 선택으로 돌아가기\n")
                                var sz = readln()
                                when(sz.toInt()){
                                    1 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    2 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    3 -> {
                                        while (true) {
                                            println(
                                                "[결제]\n"
                                                        + "1. 결제하기    | 음료 결제하기\n"
                                                        + "0. 뒤로가기    | 사이즈 선택으로 돌아가기\n"
                                            )
                                            var cc = readln()
                                            when(cc.toInt()){
                                                1 -> {
                                                    println("완료")
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }

                                        }
                                    }
                                    0 -> {
                                        break
                                    }
                                }
                            }
                        }
                         0 -> {
                            break
                         }
                    }
                }
            }
            5 -> {
                println("[장바구니 목록]")
                for (i in 0 until basketlist.size) {
                    println("${i + 1}. ${basketlist[i]} ")
                }
                println("총 금액 : ${cost}\n"
                    +"1. 구매하기 0. 뒤로가기")
                val cho = readln()
                if (!cho.isNumeric()) {
                    System.err.println("메뉴 입력은 숫자만 가능합니다")
                    continue
                }
                when (cho.toInt()) {
                    1 -> {
                        println("결제가 완료 되었습니다. 감사합니다.")
                        continue
                    }
                    0 -> {
                        continue
                    }
                }
            }
            //실행종료
            0 -> {
                break
            }
        }
    }
}