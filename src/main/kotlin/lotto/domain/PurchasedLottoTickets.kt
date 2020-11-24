package lotto.domain

class PurchasedLottoTickets(
    val lottoTickets: List<LottoTicket>
) {
    val size = lottoTickets.size

    override fun toString(): String {
        return lottoTickets.joinToString("\n")
    }
}
