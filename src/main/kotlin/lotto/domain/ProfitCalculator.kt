package lotto.domain

import lotto.view.InputView

class ProfitCalculator(private val lottoList: List<List<Int>>) {
    var mapOfResult = mapOf<Int, Int>()

    fun calculate(winningNumberList: List<Int>?, amountOfLotto: Int?): Double? {
        mapOfResult = rankResult(winningNumberList!!)
        var totalPrize = 0.0
        mapOfResult.forEach {
            totalPrize += it.key * it.value
        }
        return totalPrize / amountOfLotto!!
    }


    private fun rankResult(winningNumberList: List<Int>): Map<Int, Int> {
        val winnerChecker = WinnerChecker()
        val mapOfLotteryResult = winnerChecker.checkLotteryResult(lottoList, winningNumberList)
        val mapOfResult = mutableMapOf<Int, Int>()

        mapOfResult[THREE_MATCHED] = mapOfLotteryResult.filter { it == 3 }.size
        mapOfResult[FOUR_MATCHED] = mapOfLotteryResult.filter { it == 4 }.size
        mapOfResult[FIVE_MATCHED] = mapOfLotteryResult.filter { it == 5 }.size
        mapOfResult[SIX_MATCHED] = mapOfLotteryResult.filter { it == 6 }.size

        return mapOfResult
    }

    companion object {
        private const val THREE_MATCHED = 5_000
        private const val FOUR_MATCHED = 50_000
        private const val FIVE_MATCHED = 1_500_000
        private const val SIX_MATCHED = 2_000_000_000
    }
}
