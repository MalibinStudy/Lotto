package lotto.domain

object LottoMachine {
    private const val LOTTO_PRICE = 1000

    fun issueLottoTickets(money: Int): LottoTickets {
        val lottoTicketCount = getAmountOfLottoTickets(money)
        return LottoTickets.create(lottoTicketCount)
    }

    fun getAmountOfLottoTickets(money: Int): Int {
        return money / LOTTO_PRICE
    }
}
