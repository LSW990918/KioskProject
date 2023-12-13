@file:Suppress("UNREACHABLE_CODE")

package Kiosk

fun String.isNumeric(): Boolean {
    return try {
        this.toInt()
        true
    } catch (e: Exception) {
        false
    }
}

fun main() {
    println("버거킹에 오신것을 환영합니다!")
    while (true) {
        println(
            "[BURGURKING MENU]\n"
                    + "1. Whopper         | 순 쇠고기 패티에 싱싱한 야채가 가득~\n"
                    + "2. Chicken burger  | 에그번과 고소한 소스, 치킨패티의 만남! \n"
                    + "3. Side            | 신선한 재료만을 엄선해서 버거킹만의 비법으로 바삭하게!\n"
                    + "4. Drink           | 탄산으로 더 짜릿하게!\n"
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
                            + "1. Whopper            | 버거킹의 대표 메뉴 쇠고기패티 와퍼!\n"
                            + "2. Bulgogi whopper    | 불맛 가득 쇠고기 패티가 들어간 와퍼에 달콤한 불고기 소스까지!\n"
                            + "3. Monster whopper    | 기본재료에 치킨패티, 베이컨, 화끈한 디아블로 소스를 더한 와퍼!\n"
                            + "4. Cube steak whopper | 고기에 고기를 쌓아만든 고기 맛의 정점\n"
                            + "0. 뒤로가기            | 전체메뉴로 돌아가기\n"
                    )
                    var ww = readln()  //와퍼 선택하기
                    val buy = Buy()  //buy = Buy 클래스
                    when (ww.toInt()) {
                        1 -> { //1번(33줄) 선택시
                            while (true) {
                                var w = Basic()  //w = 기본 와퍼
                                buy.name(Basic()) //해당 와퍼 소개 내용
                                val b = readln()
                                when (b.toInt()) {
                                    1 -> {
                                        buy.one(Basic()) //단품 구매창
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
                                        buy.set(Basic()) //세트 구매창
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
                        2 -> {
                        }
                        3 -> {
                        }
                        4 -> {
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
                                    1 -> {  //결제
                                        println("${f.price}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                        break
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            2 -> {
                                buy.set(fries()) //사이즈업 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> {  //결제
                                        println("${f.set}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                        break
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
                                    1 -> {  //결제
                                        println("${cz.price}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                        break
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            2 -> {
                                buy.set(ch()) //사이즈업 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> {  //결제
                                        println("${cz.set}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                        break
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
                                    1 -> {  //결제
                                        println("${oo.price}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                        break
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            2 -> {
                                buy.set(on()) //사이즈업 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> {  //결제
                                        println("${oo.set}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                        break
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
                                    1 -> {  //결제
                                        println("${n.price}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                        break
                                    }
                                    0 -> {
                                        continue
                                    }
                                }
                            }
                            2 -> {
                                buy.set(ng()) //사이즈업 구매창
                                var purchase = readln()
                                when (purchase.toInt()) {
                                    1 -> {  //결제
                                        println("${n.set}결제가 완료되었습니다") // 결제화면으로 넘어가기
                                        break
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

            }
            //실행종료
            0 -> {
                break
            }
        }
    }
}