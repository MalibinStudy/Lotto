package lotto.domain

class StatisticalGenerator(
    private val purchasedLottoTickets: PurchasedLottoTickets
) {

    fun getStatisticsUse(lastWeekLottoTicket: LottoTicket): LottoStatistics {
        return purchasedLottoTickets.lottoTickets
            .map { LottoResult.findByMatchNumOf(it.getMatchingCountAbout(lastWeekLottoTicket)) }
            .groupingBy { it }
            .eachCount()
            .let { LottoStatistics(it) }
    }
}
