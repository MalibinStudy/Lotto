package lotto.domain

import lotto.domain.data.Money
import lotto.domain.data.Rank
import lotto.domain.data.WinResults

class ProfitCalculator {
    fun getProfitRatio(purchaseCost: Money, winResults: WinResults): Double {
        var totalProfit = 0.00
        repeat(Rank.values().size) {
            totalProfit += winResults.getProfitAt(Rank.values()[it])
        }
        return kotlin.math.round(totalProfit / purchaseCost.value * ONE_HUNDRED) / ONE_HUNDRED
    }

    companion object {
        const val ONE_HUNDRED = 100
    }
}
