package lotto.domain.data

import java.util.EnumMap

data class WinResults(
    val result: EnumMap<Rank, Int>
) {
    fun getProfitAt(rank: Rank): Double {
        val winnerCount = result[rank] ?: 0
        return rank.calculateProfit(winnerCount)
    }
}
