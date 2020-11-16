package lotto.domain

class ProfitCalculator {
    fun getProfitRatio(inputPrice: Int, outputPrice: Double): Double {
        return kotlin.math.round(outputPrice / inputPrice * ONE_HUNDRED) / ONE_HUNDRED
    }

    fun getTotalProfit(winLottos: List<WinLotto>): Double {
        var totalProfit = 0.00
        for (i in winLottos.indices) {
            val winnerCount = winLottos[i].getWinnerCount()
            totalProfit += winLottos[i].calculateWinPrice(winnerCount)
        }
        return totalProfit
    }

    companion object {
        const val ONE_HUNDRED = 100
    }
}
