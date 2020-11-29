package lotto.domain

class PurchasedLottoTickets(
    val lottoTickets: List<LottoTicket>
) {
    var size: Int = lottoTickets.size
        private set

    override fun toString(): String {
        return lottoTickets.joinToString("\n")
    }

    fun getStatistics(
        lastWeekLottoTicket: LottoTicket,
        bonusNumber: LottoNumber
    ): LottoStatistics {
        return lottoTickets.map { it.getLottoResultWith(lastWeekLottoTicket, bonusNumber) }
            .groupingBy { it }
            .eachCount()
            .let { LottoStatistics(it) }
    }
}
