package lotto.domain

class LottoShop {
    private val lottoTickets = mutableListOf<LottoTicket>()
    private lateinit var drawingMachine: DrawingMethod

    fun installDrawingMachine(drawingMethod: DrawingMethod) : LottoShop {
        this.drawingMachine = drawingMethod
        return this
    }

    fun sellsLottoTickets(price: Int): LottoBundle {
        repeat(price / LOTTO_UNIT_PRICE) { lottoTickets.add(drawingMachine.getLottoTicket()) }
        return LottoBundle(lottoTickets.toList())
    }

    private companion object {
        const val LOTTO_UNIT_PRICE = 1000
    }
}
