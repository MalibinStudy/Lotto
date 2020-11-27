package lotto.view

import lotto.domain.LottoNum
import lotto.domain.LottoNumCache
import lotto.domain.Money

object InputView {
    fun receiveMoney(): Money {
        println("구입금액을 입력해 주세요.")
        return Money(readLine()!!.toInt())
    }

    fun receiveWinLottoNumbers(): List<LottoNum> {
        println("지난 주 당첨 번호를 입력해주세요.")
        return readLine()!!.split(", ")
            .map {
                LottoNumCache.getLottoNum(
                    it.toInt()
                )
            }
    }
}
