package lotto.domain

class LottoShop(private val drawingMachine: DrawingMethod) {
    private val lottoTickets = mutableListOf<LottoTicket>()

    fun sellsLottoTickets(price: Int): LottoBundle {
        repeat(price / LOTTO_UNIT_PRICE) { lottoTickets.add(drawingMachine.getLottoTicket()) }
        return LottoBundle(lottoTickets.toList())
    }

    private companion object {
        const val LOTTO_UNIT_PRICE = 1000
    }
}
