package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.Money

object InputView {
    fun receiveMoney(): Money {
        println("구입금액을 입력해 주세요.")
        return Money(readLine()!!.toInt())
    }

    fun receiveWinLottoNumbers(): List<String> {
        println("지난 주 당첨 번호를 입력해주세요.")
        return readLine()!!.split(", ")
    }

    fun receiveBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해주세요.")
        return LottoNumber.create(readLine()!!.toInt())
    }
}
