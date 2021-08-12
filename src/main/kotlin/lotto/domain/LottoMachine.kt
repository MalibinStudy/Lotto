package lotto.domain

object LottoMachine {
    private const val LOTTO_PRICE = 1000

    fun issueLottoTickets(money: Int, lottoTicketGenerator: LottoTicketGenerator): LottoTickets {
        val lottoTicketCount = getLottoTicketCount(money)
        return LottoTickets.create(lottoTicketCount, lottoTicketGenerator)
    }

    private fun getLottoTicketCount(money: Int): Int {
        return money / LOTTO_PRICE
    }
}
