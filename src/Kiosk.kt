@file:Suppress("UNREACHABLE_CODE")

package Classes

fun String.isNumeric(): Boolean {
    return try {
        this.toInt()
        true
    } catch (e: Exception) {
        false
    }
}

fun main() {
    var money = (25000..80000).random()
    println("초기금액 ${money}원이 지급되었습니다.")
    println("버거킹에 오신것을 환영합니다!")
    while (true) {
        println(
            "[BURGURKING MENU]\n"
                    + "1. Whopper         | 순 쇠고기 패티에 싱싱한 야채가 가득~\n"
                    + "2. Chicken burger  | 에그번과 고소한 소스, 치킨패티의 만남! \n"
                    + "3. Side            | 신선한 재료만을 엄선해서 버거킹만의 비법으로 바삭하게!\n"
                    + "4. Drink           | 탄산으로 더 짜릿하게!\n"
                    + "0. 종료             | 키오스크 종료\n"
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
                            + "1. Whopper            | W  8.0 | 버거킹의 대표 메뉴 쇠고기패티 와퍼!\n"
                            + "2. Bulgogi whopper    | W  8.0 | 불맛 가득 쇠고기 패티가 들어간 와퍼에 달콤한 불고기 소스까지!\n"
                            + "3. Monster whopper    | W 10.2 | 기본재료에 치킨패티, 베이컨, 화끈한 디아블로 소스를 더한 와퍼!\n"
                            + "4. Cube steak whopper | W  9.9 | 고기에 고기를 쌓아만든 고기 맛의 정점\n"
                            + "0. 뒤로가기            | 전체메뉴로 돌아가기\n")
                    var ww = readln()  //와퍼 선택하기
                    if (!ww.isNumeric()) {
                        System.err.println("입력은 숫자만 가능합니다")
                        continue }
                    val buy = Buy()  //buy = Buy 클래스
                    when (ww.toInt()) {
                        1 -> { //1번(33줄) 선택시 기본 와퍼
                            while (true) {
                                var w = Basic()  //w = 기본 와퍼
                                buy.name(Basic()) //해당 와퍼 소개 내용
                                val b = readln()
                                when (b.toInt()) {
                                    1 -> {
                                        buy.one(Basic()) //단품 구매창
                                        var purchase = readln()
                                        when (purchase.toInt()) {
                                            1 -> { //결제
                                                if (money-w.price < 0) {
                                                    println("잔액이 부족합니다.")
                                                } else {
                                                    println("결제금액 ${w.price}원이 결제되었습니다.\n"
                                                            + "남은 잔액은 ${money-w.price}원 입니다. 감사합니다.\n")
                                                    money -= w.price //결제완료후 잔액차감
                                                }
                                                break
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
                                                if (money-w.set < 0) {
                                                    println("잔액이 부족합니다.")
                                                } else {
                                                    println("결제금액 ${w.set}원이 결제되었습니다.\n"
                                                            + "남은 잔액은 ${money-w.set}원 입니다. 감사합니다.\n")
                                                    money -= w.set //결제완료후 잔액차감
                                                }
                                                break
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
                                            1 -> {  //결제
                                                println("${w.price}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                                break
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
                                            1 -> {  //결제
                                                println("${w.set}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                                break
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
                                            1 -> {  //결제
                                                println("${w.price}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                                break
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
                                            1 -> {  //결제
                                                println("${w.set}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                                break
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
                                            1 -> {  //결제
                                                println("${w.price}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                                break
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
                                            1 -> {  //결제
                                                println("${w.set}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                                break
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
            //실행종료
            0 -> {
                break
            }
        }
    }
}