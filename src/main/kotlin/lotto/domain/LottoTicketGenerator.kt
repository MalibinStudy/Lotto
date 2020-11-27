package lotto.domain

interface LottoTicketGenerator {
    fun issue(): LottoTicket
}
