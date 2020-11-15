package lotto.view

import lotto.domain.Validation
import java.util.regex.Pattern

object InputView {
    fun getPurchasePrice(): Int {
        print("구입 금액을 입력해주세요: ")
        val purchasePrice = readLine()!!.toInt()
        return purchasePrice
    }

    fun getWinningNumber(): List<Int> {
        print("지난 주 당첨 번호를 입력해 주세요: ")
        val winningNumber = readLine()
        val winningNumberList = winningNumber?.split(Pattern.compile(", "))?.map { it.toInt() }
        Validation.validateWinningNumbers(winningNumberList!!)
        return winningNumberList
    }
}
