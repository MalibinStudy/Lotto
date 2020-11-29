package lotto.domain

import lotto.domai.RandomNumGenerator

class LottoTicketMachine(private val randomNumGenerator: RandomNumGenerator) {

    fun make(): LottoTicket {
        val lottoNumbers = mutableListOf<LottoNumber>()
        while (lottoNumbers.size < LottoTicket.LOTTO_TICKET_LENGTH) {
            val candidateNumber = LottoNumber.create(randomNumGenerator.generate())
            if (!lottoNumbers.contains(candidateNumber)) {
                lottoNumbers.add(candidateNumber)
            }
        }
        return LottoTicket(lottoNumbers)
    }

    fun make(count: Int): LottoTickets {
        return LottoTickets(
            List(count) { make() }
        )
    }
}
