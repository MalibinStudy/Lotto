package lotto.view

import lotto.domain.data.Lotto
import lotto.domain.InputChecker
import lotto.domain.data.LottoNum
import lotto.domain.data.Money

class InputView {
    private val inputChecker = InputChecker()
    fun getPurchasePrice(): Money {
        println("구매 금액을 입력해주세요.")
        val purchasePrice = readLine()!!
        inputChecker.checkPurchasePrice(purchasePrice)
        return Money(purchasePrice.toInt())
    }

    fun requestWinningLotto(): Lotto {
        println("지난주 당첨 번호를 입력해 주세요.")
        val numsString = readLine()!!
        return getWinLottoNum(numsString)
    }

    private fun getWinLottoNum(numsString: String): Lotto {
        val winnerNumsString = numsString.split(DELIMITER)
        inputChecker.checkWinLottoNum(winnerNumsString)
        val winLottoNums = winnerNumsString.map { LottoNum(it.toInt()) }.toSet()
        return Lotto(winLottoNums)
    }

    companion object {
        const val DELIMITER = ", "
    }
}
