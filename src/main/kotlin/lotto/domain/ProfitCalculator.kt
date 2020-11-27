package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object ProfitCalculator {
    private fun getPrizeSum(winningResults: List<WinningResult>): Int {
        return winningResults.fold(0, { total, winningResult -> total + winningResult.prize })
    }

    fun getProfit(winningResults: List<WinningResult>, purchaseMoney: Int): BigDecimal {
        val prizeSum = BigDecimal(getPrizeSum(winningResults))
        val purchaseMoney = BigDecimal(purchaseMoney)
        return prizeSum.divide(purchaseMoney, 2, RoundingMode.FLOOR);
    }
}
