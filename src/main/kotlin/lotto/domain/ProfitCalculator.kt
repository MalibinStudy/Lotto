package lotto.domain

import lotto.domain.data.Money
import lotto.domain.data.WinLotto
import java.util.EnumMap

class ProfitCalculator {
    fun getProfitRatio(purchaseCost: Money, winLottos: EnumMap<WinLotto, Int>): Double {
        val totalProfit = getTotalProfit(winLottos)
        return kotlin.math.round(totalProfit / purchaseCost.getValue() * ONE_HUNDRED) / ONE_HUNDRED
    }

    private fun getTotalProfit(winLottos: EnumMap<WinLotto, Int>): Double {
        var totalProfit = 0.00
        winLottos.forEach { (winLOtto, winnerCount) ->
            totalProfit += (winLOtto.winPrice * winnerCount)
        }
        return totalProfit
    }

    companion object {
        const val ONE_HUNDRED = 100
    }
}
