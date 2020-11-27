package lotto.domain

object LottoTicketRandomGenerator : LottoTicketGenerator {
    private val wholeLottoNumbers =
        (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER)
            .map { LottoNumber.valueOf(it) }

    override fun issue(): LottoTicket {
        return LottoTicket(getRandomLottoNumbers())
    }

    private fun getRandomLottoNumbers(): Set<LottoNumber> {
        return wholeLottoNumbers
            .shuffled()
            .take(LottoTicket.LOTTO_NUMBER_COUNT)
            .sortedBy { it.number }
            .toSet()
    }
}
