package lotto.domain

object LottoScoringMachine {
    private const val LEAST_WIN_NUMBER = 3

    fun scoreLottos(winLottoTicket: LottoTicket, lottoTickets: List<LottoTicket>): WinLottoStatistics {
        val lottoWinScore = WinLottoStatistics()

        lottoTickets.asSequence()
            .map { it.countSameNumber(winLottoTicket) }
            .filter { it >= LEAST_WIN_NUMBER }
            .map { WinLotto.findInstance(it) }
            .map { lottoWinScore.increaseLottoCount(it) }
            .toList()
        return lottoWinScore
    }
}
