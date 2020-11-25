package lotto.domain

import lotto.domain.LottoTicket.Companion.LOTTO_LENGTH

class DrawingMachine(range: IntRange) : DrawingMethod {
    private val lottoBalls = mutableListOf<LottoNumber>()

    init {
        range.forEach { lottoBalls.add(LottoNumber(it)) }
    }

    override fun getLottoTicket(): LottoTicket = LottoTicket(
        lottoBalls
            .shuffled()
            .take(LOTTO_LENGTH)
            .sortedBy { it.lottoNumber }
    )
}
