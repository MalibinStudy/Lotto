package lotto.domain

class LottoBundle(val lottoTickets: List<LottoTicket>) {
    fun check(winningTicket: LottoTicket): PrizeCheckList {
        val lottoCheckList = lottoTickets.map { it.check(winningTicket) }
        val prizeStrategy = lottoCheckList.map { Rank.checkLottoPrize(it) }
        return PrizeCheckList(prizeStrategy)
    }
}
