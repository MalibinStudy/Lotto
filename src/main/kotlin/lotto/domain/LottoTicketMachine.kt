package lotto.domain

import lotto.domai.RandomNumGenerator
import lotto.domain.LottoTicket.Companion.LOTTO_TICKET_LENGTH

class LottoTicketMachine(private val randomNumGenerator: RandomNumGenerator) {
    fun make(): LottoTicket {
        val lottoNums = (1..LOTTO_TICKET_LENGTH).map {
            LottoNumCache.getLottoNum(
                randomNumGenerator.generate()
            )
        }
        return LottoTicket(lottoNums)
    }
}
