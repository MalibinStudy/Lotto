package lotto.domain

import lotto.view.InputView

class ProfitCalculator {
    var mapOfResult = mapOf<Int, Int>()

    fun calculate(lottoList: List<List<Int>>): Double? {
        mapOfResult = rankResult(lottoList)
        var totalPrize = 0.0
        mapOfResult.forEach {
            totalPrize += it.key * it.value
        }
        return totalPrize / InputView.amountOfLotto!!
    }

    private fun rankResult(lottoList: List<List<Int>>): Map<Int, Int> {
        val winnerChecker = WinnerChecker()
        val mapOfLotteryResult = winnerChecker.checkLotteryResult(lottoList)

        val mapOfResult = mutableMapOf<Int, Int>()
        mapOfResult.put(THREE_MATCHED, mapOfLotteryResult.filter { it == 3 }.size)
        mapOfResult.put(FOUR_MATCHED, mapOfLotteryResult.filter { it == 4 }.size)
        mapOfResult.put(FIVE_MATCHED, mapOfLotteryResult.filter { it == 5 }.size)
        mapOfResult.put(SIX_MATCHED, mapOfLotteryResult.filter { it == 6 }.size)

        return mapOfResult
    }

    companion object {
        private const val THREE_MATCHED = 5_000
        private const val FOUR_MATCHED = 50_000
        private const val FIVE_MATCHED = 1_500_000
        private const val SIX_MATCHED = 2_000_000_000
    }
}
