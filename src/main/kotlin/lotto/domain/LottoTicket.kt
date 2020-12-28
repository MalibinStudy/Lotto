package lotto.domain

class LottoTicket(val lottoTicket: List<LottoNumber>) {
    init {
        val lottoTicketSet = lottoTicket.toSet()
        require(lottoTicketSet.size == lottoTicket.size) { "로또에 중복된 숫자는 입력하시면 안됩니다" }
        require(lottoTicket.size == LOTTO_LENGTH) { "로또의 입력 길이는 ${LOTTO_LENGTH}가 되어야 합니다. 입력 로또 길이 ${lottoTicket.size}" }
    }

    fun check(winningTicket: LottoTicket): LottoResult {
        val matchCount = lottoTicket.count {
            winningTicket.lottoTicket.take(WINNING_NUMBER_LENGTH).contains(it)
        }
        val matchBonus = winningTicket.lottoTicket.last() == lottoTicket.last()
        return LottoResult(matchCount, matchBonus)
    }

    override fun toString(): String {
        return lottoTicket.toString()
    }

    companion object {
        const val LOTTO_LENGTH = 7
        const val WINNING_NUMBER_LENGTH = 6
    }
}
