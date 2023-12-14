@file:Suppress("UNREACHABLE_CODE")

package Classes

import BuyDrink
import Coca
import Kiosk.*
import Mtndwe
import Spr
import Wel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import kotlin.concurrent.thread

fun String.isTime(): Boolean {
    val format1 = SimpleDateFormat("HHmm")
    val cTime1 = format1.format(System.currentTimeMillis()).toInt()
    return if (cTime1 in 2300..2330) {
        false
    } else {
        true
    }
}

fun main() {
    val format2 = SimpleDateFormat("현재시각 : HH:mm")
    val cTime2 = format2.format(System.currentTimeMillis())

    val basketlist = arrayListOf<String>()
    var cost = 0
    var money = (20000..50000).random()

    while (true) {
        println("[BURGURKING KIOSK]\n"
                + "버거킹 키오스크 입니다. ${cTime2}\n"
                + "1. 키오스크 시작 0. 종료\n")
        val Kiosk = readln()
        if (!Kiosk.isNumeric()) {
            System.err.println("메뉴 입력은 숫자만 가능합니다")
            continue
        }
        when (Kiosk.toInt()) {
            1 -> {
                if (!Kiosk.isTime()) {
                    println("23:00 ~ 23:30 사이에는 키오스크 점검시간입니다.\n 이용에 불편을 드려 죄송합니다.")
                    break
                }
                println("초기금액 ${money}원이 지급되었습니다.")
                runBlocking {
                    launch {
                        delay(2000)
                        println("버거킹에 오신것을 환영합니다!")
                    }
                }
                while (true) {
                    runBlocking {
                        launch {
                            delay(2000)
                            println("[BURGURKING MENU]\n"
                                    + "1. Whopper         | 순 쇠고기 패티에 싱싱한 야채가 가득~\n"
                                    + "2. Chicken burger  | 에그번과 고소한 소스, 치킨패티의 만남! \n"
                                    + "3. Side            | 신선한 재료만을 엄선해서 버거킹만의 비법으로 바삭하게!\n"
                                    + "4. Drink           | 탄산으로 더 짜릿하게!\n"
                                    + "5. 장바구니         | 장바구니 확인하기\n"
                                    + "0. 시작화면으로      |\n")
                        }
                    }
                    thread(start = true) {
                        while (true) {
                            println("현재 장바구니 갯수 : ${basketlist.size}" )
                            runBlocking {
                                launch {
                                    delay(20000)
                                }
                            }
                        }
                    }
                    val main = readln()
                    if (!main.isNumeric()) {
                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                        continue
                    }
                    when (main.toInt()) {
                        1 -> {
                            while (true) {
                                runBlocking {
                                    launch {
                                        delay(1000)
                                        println(
                                            "[Whopper MENU]\n"
                                                    + "1. 와퍼               | W  8.0 | 버거킹의 대표 메뉴 쇠고기패티 와퍼!\n"
                                                    + "2. 불고기 와퍼         | W  8.0 | 불맛 가득 쇠고기 패티가 들어간 와퍼에 달콤한 불고기 소스까지!\n"
                                                    + "3. 몬스터 와퍼         | W 10.2 | 기본재료에 치킨패티, 베이컨, 화끈한 디아블로 소스를 더한 와퍼!\n"
                                                    + "4. 큐브 스테이크 와퍼   | W  9.9 | 고기에 고기를 쌓아만든 고기 맛의 정점\n"
                                                    + "0. 뒤로가기            | 전체메뉴로 돌아가기\n")
                                    }
                                }
                                var ww = readln()  //와퍼 선택하기
                                if (!ww.isNumeric()) {
                                    System.err.println("입력은 숫자만 가능합니다")
                                    continue
                                }
                                val buy = Buy()  //buy = Buy 클래스
                                when (ww.toInt()) {
                                    1 -> { //1번 선택시 기본 와퍼
                                        while (true) {
                                            var w = Basic()  //w = 기본 와퍼
                                            buy.name(Basic()) //해당 와퍼 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buy.one(Basic()) //단품 구매창
                                                    cost = cost + w.price
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name} | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name} 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name}세트 | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name} 세트 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buy.one(Bulg()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name} | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${w.name} 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name}세트 | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${w.name} 세트 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buy.one(Mons()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name} | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${w.name} 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name}세트 | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${w.name} 세트 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buy.one(Cube()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name} | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${w.name} 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name}세트 | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${w.name} 세트 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                            while (true){
                                runBlocking {
                                    launch {
                                        delay(1000)
                                        println("[Chickenburger MENU]\n"
                                                + "1. 치킨 버거           | W  6.6 | 고소한 마요소스와 치킨패티 버거!\n"
                                                + "2. 바베큐 치킨 버거     | W  6.6 | 치킨 패티에 불맛 가득 바베큐 소스까지!\n"
                                                + "3. 롱치킨 버거         | W  8.1 | 길어진 만큼 소스와 싱싱한 야채가 가득!\n"
                                                + "4. 치킨킹             | W  9.9 | 스파이시한 통닭다리살로 만들어진 프리미엄 치킨버거. 치킨킹!\n"
                                                + "0. 뒤로가기           | 전체메뉴로 돌아가기\n")
                                    }
                                }
                                var ww = readln()
                                if (!ww.isNumeric()) {
                                    System.err.println("메뉴 입력은 숫자만 가능합니다")
                                    continue
                                }
                                if (!ww.isNumeric()) {
                                    System.err.println("입력은 숫자만 가능합니다")
                                    continue }
                                val ch = Chic()
                                when (ww.toInt()) {
                                    1 -> {//치킨버거
                                        while (true) {
                                            var w = Base()
                                            ch.name(Base()) //해당 버거 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    ch.one(Base()) //단품 구매창
                                                    cost = cost + w.price
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name} | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
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
                                                    ch.set(Base()) //세트 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name}세트 | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
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
                                                    ch.displayInfo(Base())
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                    2 -> { // 바베큐 치킨버거
                                        while (true) {
                                            var w = Barb()
                                            ch.name(Barb()) //해당 버거 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    ch.one(Barb()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name} | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
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
                                                    ch.set(Barb()) //세트 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name}세트 | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
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
                                                    ch.displayInfo(Barb())
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                    3 -> { // 롱치킨버거
                                        while (true) {
                                            var w = Long()
                                            ch.name(Long()) //해당 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    ch.one(Long()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name} | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
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
                                                    ch.set(Long()) //세트 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name}세트 | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
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
                                                    ch.displayInfo(Long())
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                    4 -> { // 치킨킹
                                        while (true) {
                                            var w = King()  //w = 기본 와퍼
                                            ch.name(King()) //해당 와퍼 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    ch.one(King()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name} | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
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
                                                    ch.set(King()) //세트 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${w.name}세트 | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
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
                                                    ch.displayInfo(King())
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                        //사이드
                        3 -> {
                            while (true) {
                                runBlocking {
                                    launch {
                                        delay(1000)
                                        println(
                                            "[Side MENU]\n"
                                                    + "1. 감자튀김            | 세계최고의 감자만 엄선해서 버거킹만의 비법으로 바삭하게!\n"
                                                    + "2. 치즈스틱            | 진하고 고소한 자연 모짜렐라가 가득한 치즈스틱!\n"
                                                    + "3. 어니언 링           | 더 바삭하게 한 입에 쏙!\n"
                                                    + "4. 너겟킹              | 바삭~ 촉촉~ 한입에 쏙 부드러운 너겟킹\n"
                                                    + "0. 뒤로가기            | 전체메뉴로 돌아가기\n"
                                        )
                                    }
                                }
                                var sd = readln()
                                if (!sd.isNumeric()) {
                                    System.err.println("메뉴 입력은 숫자만 가능합니다")
                                    continue
                                }
                                val buy = Buyside()
                                when (sd.toInt()) {
                                    1 -> {
                                        while (true) {
                                            var f = fries()  //f = 감자튀김
                                            buy.name(fries()) //감자튀김 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buy.one(fries()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += f.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${f.name}(M) | ${f.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${f.name}(M) 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += f.up
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${f.name}(L) | ${f.up} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${f.name}(L) 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                        while (true) {
                                            var cz = ch()  //cz = 치즈
                                            buy.name(ch()) //감자튀김 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buy.one(ch()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += cz.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${cz.name}(M) | ${cz.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${cz.name}(M) 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
                                                                continue
                                                            } else {
                                                                cost -= cz.price
                                                                println("잔액이 부족합니다.")
                                                            }
                                                            continue
                                                        }
                                                    }
                                                }
                                                2 -> {
                                                    buy.up(ch()) //사이즈업 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += cz.up
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${cz.name}(L) | ${cz.up} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${cz.name}(L) 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                    3 -> {
                                        while (true) {
                                            var oo = on()  //oo = 어니언링
                                            buy.name(on()) //어니언링 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buy.one(on()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += oo.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${oo.name}(M) | ${oo.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${oo.name}(M) 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
                                                                continue
                                                            } else {
                                                                cost -= oo.price
                                                                println("잔액이 부족합니다.")
                                                            }
                                                            continue
                                                        }
                                                    }
                                                }
                                                2 -> {
                                                    buy.up(on()) //사이즈업 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += oo.up
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${oo.name}(L) | ${oo.up} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${oo.name}(L) 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                                    4 -> {
                                        while (true) {
                                            var n = ng()  //n = 너겟
                                            buy.name(ng()) //너겟 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buy.one(ng()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += n.price
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${n.name}(M) | ${n.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${n.name}(M) 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
                                                                continue
                                                            } else {
                                                                cost -= n.price
                                                                println("잔액이 부족합니다.")
                                                            }
                                                            continue
                                                        }
                                                    }
                                                }
                                                2 -> {
                                                    buy.up(ng()) //사이즈업 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += n.up
                                                            var mon = money - cost
                                                            if (mon >= 0) {
                                                                var basket = " ${n.name}(L) | ${n.up} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println(
                                                                    "장바구니에 ${n.name}(L) 추가 완료!\n"
                                                                            + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n"
                                                                )
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
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
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
                            while (true) {
                                runBlocking {
                                    launch {
                                        delay(1000)
                                        println(
                                            "[SoftDrink MENU]\n"
                                                    + "1. 코카콜라       | 햄버거의 영원한 단짝 코카콜라! \n"
                                                    + "2. 스프라이트     | 콜라의 라이벌 스프라이트 샤워하실래요?\n"
                                                    + "3. 웰치스        | 포도의 산뜻함과 청량감이 만났다. 웰치스!\n"
                                                    + "4. 마운틴 듀     | 새로운 맛의 청량음료를 원한다면 골라라 마운틴듀!\n"
                                                    + "0. 뒤로가기      | 전체메뉴로 돌아가기\n")
                                    }
                                }
                                var sd = readln()  //음료 선택하기
                                if (!sd.isNumeric()) {
                                    System.err.println("입력은 숫자만 가능합니다")
                                    continue
                                }
                                val buyDrink = BuyDrink()
                                when (sd.toInt()) {
                                    1 -> { //코카콜라
                                        while (true) {
                                            var w = Coca()
                                            buyDrink.name(Coca()) //해당 음료 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buyDrink.one(Coca()) //구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> {
                                                            cost += w.price//결제
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.price
                                                            } else {
                                                                var basket = " ${w.name}(M) | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(M) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                2 -> {
                                                    buyDrink.set(Coca()) //L 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> {// L 결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.set
                                                            } else {
                                                                var basket = " ${w.name}(L) | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(L) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                3 -> {
                                                    buyDrink.set2(Coca()) //XL 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set2
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.set2
                                                            } else {
                                                                var basket = " ${w.name}(XL) | ${w.set2} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(XL) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
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
                                        while (true) {
                                            var w = Spr()
                                            buyDrink.name(Spr()) //해당 음료 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buyDrink.one(Spr()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> {
                                                            cost += w.price//결제
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.price
                                                            } else {
                                                                var basket = " ${w.name}(M) | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(M) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                2 -> {
                                                    buyDrink.set(Spr()) //세트 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> {// L 결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.set
                                                            } else {
                                                                var basket = " ${w.name}(L) | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(L) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                3 -> {
                                                    buyDrink.set2(Spr()) //세트 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set2
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.set2
                                                            } else {
                                                                var basket = " ${w.name}(XL) | ${w.set2} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(XL) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }
                                        }
                                    }
                                    3 -> {//웰치스
                                        while (true) {
                                            var w = Wel()
                                            buyDrink.name(Wel()) //해당 음료 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buyDrink.one(Wel()) //단품 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> {
                                                            cost += w.price//결제
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.price
                                                            } else {
                                                                var basket = " ${w.name}(M) | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(M) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                2 -> {
                                                    buyDrink.set(Wel()) // 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> {// L 결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.set
                                                            } else {
                                                                var basket = " ${w.name}(L) | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(L) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }

                                                3 -> {
                                                    buyDrink.set2(Wel()) //구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set2
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.set2
                                                            } else {
                                                                var basket = " ${w.name}(XL) | ${w.set2} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(XL) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                0 -> {
                                                    break
                                                }
                                            }
                                        }
                                    }
                                    4 -> { //마운틴듀
                                        while (true) {
                                            var w = Mtndwe()
                                            buyDrink.name(Mtndwe()) // 소개 내용
                                            val b = readln()
                                            if (!b.isNumeric()) {
                                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                continue
                                            }
                                            when (b.toInt()) {
                                                1 -> {
                                                    buyDrink.one(Mtndwe()) //구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> {
                                                            cost += w.price//결제
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.price
                                                            } else {
                                                                var basket = " ${w.name}(M) | ${w.price} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(M) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                2 -> {
                                                    buyDrink.set(Mtndwe()) //세트 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> {// L 결제
                                                            cost += w.set
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.set
                                                            } else {
                                                                var basket = " ${w.name}(L) | ${w.set} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(L) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
                                                        }
                                                    }
                                                }
                                                3 -> {
                                                    buyDrink.set2(Mtndwe()) //세트 구매창
                                                    var purchase = readln()
                                                    if (!purchase.isNumeric()) {
                                                        System.err.println("메뉴 입력은 숫자만 가능합니다")
                                                        continue
                                                    }
                                                    when (purchase.toInt()) {
                                                        1 -> { //결제
                                                            cost += w.set2
                                                            var mon = money - cost
                                                            if (mon < 0) {
                                                                println("잔액이 부족합니다.")
                                                                cost -= w.set2
                                                            } else {
                                                                var basket = " ${w.name}(XL) | ${w.set2} | "
                                                                for(i in 1..3) {
                                                                    println(".")
                                                                    runBlocking {
                                                                        launch {
                                                                            delay(800)
                                                                        }
                                                                    }
                                                                }
                                                                basketlist.add(basket)
                                                                println("장바구니에 ${w.name}(XL) 추가 완료!\n"
                                                                        + "추가로 담을수 있는 금액은 ${mon}원 입니다. 감사합니다.\n")
                                                            }
                                                            break
                                                        }
                                                        0 -> {
                                                            continue
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
                        //장바구니
                        5 -> {
                            println("[장바구니 목록]")
                            for (i in 0 until basketlist.size) {
                                println("${i + 1}. ${basketlist[i]} ")
                                runBlocking {
                                    launch {
                                        delay(500)
                                    }
                                }
                            }
                            println(
                                "총 금액 : ${cost}\n"
                                        + "1. 구매하기 0. 뒤로가기"
                            )
                            val cho = readln()
                            if (!cho.isNumeric()) {
                                System.err.println("메뉴 입력은 숫자만 가능합니다")
                                continue
                            }
                            when (cho.toInt()) {
                                1 -> {
                                    for(i in 1..3) {
                                        println(".")
                                        runBlocking {
                                            launch {
                                                delay(800)
                                            }
                                        }
                                    }
                                    basketlist.clear()
                                    cost = 0
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
            0 -> {
                println("키오스크를 종료합니다")
                runBlocking {
                    launch {
                        delay(2000)
                    }
                }
                break
            }
        }
    }
}
fun String.isNumeric(): Boolean {
    return try {
        this.toInt()
        true
    } catch (e: Exception) {
        false
    }
}
