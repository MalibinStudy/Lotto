package lotto.domain

data class LottoTicket(private val lottoNumbers: List<LottoNumber>) {

    init {
        checkNumberCount()
        checkDuplication()
    }

    private fun checkNumberCount() {
        require(lottoNumbers.size == LOTTO_TICKET_LENGTH) { "로또 숫자는 총 6개입니다." }
    }

    private fun checkDuplication() {
        val lottoNumberSet = lottoNumbers.toSet()
        require(lottoNumberSet.size == LOTTO_TICKET_LENGTH) { "로또 숫자는 중복될 수 없습니다." }
    }

    fun countSameNumber(lottoTicket: LottoTicket): Int {
        val thisLottoTicketNumbers = this.lottoNumbers.map { it.number }
        val lottoTicketNumbers = lottoTicket.lottoNumbers.map { it.number }
        return lottoTicketNumbers.count { thisLottoTicketNumbers.contains(it) }
    }

    fun hasLottoNumber(lottoNumber: LottoNumber): Boolean = lottoNumbers.contains(lottoNumber)

    override fun toString(): String {
        val numbers = lottoNumbers.map { it.number }
        return numbers.toString()
    }

    companion object {
        const val LOTTO_TICKET_LENGTH = 6
        const val LOTTO_PRICE = 1000
    }
}
