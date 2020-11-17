package lotto.domain

object LottoScoringMachine {
    private const val LEAST_WIN_NUMBER = 3

    fun scoreLottos(winLotto: Lotto, lottos: List<Lotto>): WinLottoScore {
        val lottoWinScore = WinLottoScore()

        lottos.asSequence()
            .map { lotto -> getSameNumberCount(winLotto, lotto) }
            .filter { it >= LEAST_WIN_NUMBER }
            .map { WinLotto.findInstance(it) }
            .map { lottoWinScore.increaseLottoCount(it) }
            .toList()

        return lottoWinScore
    }

    private fun getSameNumberCount(winLotto: Lotto, lotto: Lotto): Int {
        var count = 0
        lotto.numbers.map {
            if (winLotto.checkHas(it)) count += 1
        }
        return count
    }
}
