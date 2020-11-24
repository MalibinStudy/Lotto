package lotto.domain

class LottoTicketGenerator : LottoNumberGenerateStrategy {
    private val lottoNumber = (LottoNumber.LOTTO_START_NUMBER..LottoNumber.LOTTO_END_NUMBER)
        .map { LottoNumber.valueOf(it) }

    override fun createAutoNumTicket(): LottoTicket {
        return lottoNumber.shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .sortedBy { it.number }
            .let { LottoTicket(it) }
    }

    fun makeLottoTicket(numbers: List<String>): LottoTicket {
        return LottoTicket(numbers.map { LottoNumber.valueOf(getValidLottoNumber(it)) })
    }

    private fun getValidLottoNumber(winningNumber: String): Int {
        return winningNumber.also { validateLottoNumIsInt(it) }
            .toInt()
    }

    private fun validateLottoNumIsInt(winningNumber: String) {
        require(winningNumber.toIntOrNull() is Int) {
            "당첨 번호가 숫자가 아닙니다!, 숫자가 아닌 입력된 값:$winningNumber"
        }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
