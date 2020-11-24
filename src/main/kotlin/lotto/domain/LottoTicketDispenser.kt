package lotto.domain

class LottoTicketDispenser(
    private val lottoNumberGenerateStrategy: LottoNumberGenerateStrategy
) {

    fun getLottoTickets(cost: Long): PurchasedLottoTickets {
        val amountOfTicket = cost / LottoTicket.LOTTO_PRICE
        return (1..amountOfTicket)
            .map { lottoNumberGenerateStrategy.createAutoNumTicket() }
            .let { PurchasedLottoTickets(it) }
    }
}
