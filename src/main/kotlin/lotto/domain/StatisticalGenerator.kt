package lotto.domain

class StatisticalGenerator(
    private val purchasedLottoTickets: PurchasedLottoTickets
) {

    fun makeStatisticsUse(
        lastWeekLottoTicket: LottoTicket,
        bonusNumber: LottoNumber
    ): LottoStatistics {
        return purchasedLottoTickets.lottoTickets
            .map { it.getLottoResultWith(lastWeekLottoTicket, bonusNumber) }
            .groupingBy { it }
            .eachCount()
            .let { LottoStatistics(it) }
    }
}
