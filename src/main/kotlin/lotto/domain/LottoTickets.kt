package lotto.domain

class LottoTickets(val lottoTickets: List<LottoTicket>) {
    fun getWinningResults(winningNumbers: List<LottoNumber>): List<WinningResult> {
        return lottoTickets.map { it.getWinningResult(winningNumbers) }
    }

    companion object {
        fun create(ticketCount: Int, lottoTicketGenerator: LottoTicketGenerator): LottoTickets {
            val lottoTickets = (1..ticketCount).map { lottoTicketGenerator.issue() }
            return LottoTickets(lottoTickets)
        }
    }
}
