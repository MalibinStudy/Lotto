package lotto.domain

import lotto.domain.data.Money
import lotto.domain.data.WinResults

class ProfitCalculator {
    fun getProfitRatio(purchaseCost: Money, lottosResult: WinResults): Double {
        val totalProfit = getTotalProfit(lottosResult)
        return kotlin.math.round(totalProfit / purchaseCost.value * ONE_HUNDRED) / ONE_HUNDRED
    }

    private fun getTotalProfit(lottosResult: WinResults): Double {
        var totalProfit = 0.00
        lottosResult.result.forEach { (winLOtto, winnerCount) ->
            totalProfit += (winLOtto.winPrice * winnerCount)
        }
        return totalProfit
    }

    companion object {
        const val ONE_HUNDRED = 100
    }
}
