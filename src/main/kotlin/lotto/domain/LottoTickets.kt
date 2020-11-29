package lotto.domain

class LottoTickets(val lottoTickets: List<LottoTicket>) {
    override fun toString(): String {
        return lottoTickets.map { it.toString() }
            .reduce { acc, lottoTicket -> acc + NEW_LINE + lottoTicket }
    }

    fun score(winLottoTicket: LottoTicket): WinLottoStatistics {
        val sameNumberCounts = this.lottoTickets.map { it.countSameNumber(winLottoTicket) }
        val lottoStatistics = WinLottoStatistics()
        sameNumberCounts.mapNotNull { WinLottoTicket.findInstance(it) }
            .map { lottoStatistics.increaseLottoCount(it) }
        return lottoStatistics
    }

    fun score(winLottoTicket: LottoTicket, bonusNumber: LottoNumber): WinLottoStatistics {
        val winLottoStatistics = score(winLottoTicket)

        val secondWinLottoTicketCount = this.lottoTickets
            .filter { it.hasLottoNumber(bonusNumber) }
            .filter { it.countSameNumber(winLottoTicket) == WinLottoTicket.FOUR.sameNumberCount }
            .size

        repeat(secondWinLottoTicketCount) {
            winLottoStatistics.increaseLottoCount(WinLottoTicket.FIVE_WITH_BONUS)
            winLottoStatistics.decreaseLottoCount(WinLottoTicket.FOUR)
        }
        return winLottoStatistics
    }

    companion object {
        private const val NEW_LINE = '\n'
    }
}
