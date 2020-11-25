package lotto.domain

class PurchasedLottoTickets(
    val lottoTickets: List<LottoTicket>
) {
    var size: Int = lottoTickets.size
        private set

    override fun toString(): String {
        return lottoTickets.joinToString("\n")
    }
}
