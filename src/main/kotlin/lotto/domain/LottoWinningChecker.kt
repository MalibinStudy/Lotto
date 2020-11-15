package lotto.domain

class LottoWinningChecker(
    private val lastWeekResult: List<Int>
) {
    fun getWinningStatistics(lottoNumbers: List<Lotto>): WinningStatistics {
        val winningStatistics = WinningStatistics()
        getLottoResult(lottoNumbers)
            .filter { it >= MATCHING_WINNING_NUMBER_COUNT }
            .forEach { winningStatistics.increase(it) }
        return winningStatistics
    }

    private fun getLottoResult(lottoNumbers: List<Lotto>): List<Int> {
        return lottoNumbers
            .map { getkWinningNumberCount(it) }
            .toList()
    }

    private fun getkWinningNumberCount(lotto: Lotto): Int {
        var winningNumberCount = 0
        lastWeekResult.forEach {
            if (lotto.lottoNumbers.contains(it)) winningNumberCount++
        }
        return winningNumberCount
    }

    companion object {
        private const val MATCHING_WINNING_NUMBER_COUNT = 3
    }
}
