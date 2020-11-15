package lotto.view

import lotto.domain.Lotto
import lotto.domain.Winner

class BuyLottoResultView {
    fun showProfitRatio(inspectResult: Map<Lotto, Int>, purchasePrice: Int) {
        var totalProfit = 0.00
        for (correctNum in WinLottoResultView.CORRECT_THREE..WinLottoResultView.CORRECT_SIX) {
            val winnerNum = inspectResult.filter { it.value == correctNum }.size
            val winPrice = Winner.findByCorrectNum(correctNum).winPrice
            totalProfit += (winnerNum * winPrice)
        }
        val profitRatio = kotlin.math.round(totalProfit / purchasePrice * 100) / 100
        println("총 수익률은 ${profitRatio}입니다.")
    }
}