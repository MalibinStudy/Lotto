package lotto.domain

data class LottoTicket(val numbers: List<LottoNum>) {

    init {
        checkNumberCount()
    }

    private fun checkNumberCount() {
        require(numbers.size == LOTTO_TICKET_LENGTH) { "로또 숫자는 총 6개입니다." }
    }

    fun countSameNumber(lottoTicket: LottoTicket): Int {
        val thisLottoTicketNumbers = this.numbers.map { it.num }
        val lottoTicketNumbers = lottoTicket.numbers.map { it.num }
        return lottoTicketNumbers.count { thisLottoTicketNumbers.contains(it) }
    }

    override fun toString(): String {
        val numbers = numbers.map { it.num }
        return numbers.toString()
    }

    companion object {
        const val LOTTO_TICKET_LENGTH = 6
    }
}
