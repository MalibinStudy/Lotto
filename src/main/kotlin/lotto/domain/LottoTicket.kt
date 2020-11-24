package lotto.domain

class LottoTicket(private val lottoTicket: List<LottoNumber>) {
    init {
        val lottoTicketSet = lottoTicket.toSet()
        require(lottoTicketSet.size == lottoTicket.size) { "로또에 중복된 숫자는 입력하시면 안됩니다" }
        require(lottoTicket.size == LOTTO_LENGTH) { "로또의 입력 길이는 ${LOTTO_LENGTH}가 되어야 합니다. 입력 로또 길이 ${lottoTicket.size}" }
    }

    fun check(winningTicket: LottoTicket): Int {
        return lottoTicket.count {
            winningTicket.lottoTicket
                .contains(it)
        }
    }

    override fun toString(): String {
        return lottoTicket.toString()
    }

    companion object {
        const val LOTTO_LENGTH = 6
        const val LOTTO_NUMBER_START = 1
        const val LOTTO_NUMBER_END = 45
    }
}
