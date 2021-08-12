package lotto.domain

class LottoTicket(
    lottoNumbers: List<LottoNumber>
) {
    private val lottoNumbers: Set<LottoNumber>

    init {
        this.lottoNumbers = lottoNumbers.also { validateLottoNumbers(it) }.toSet()
    }

    private fun validateLottoNumbers(lottoNumbers: List<LottoNumber>) {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 반드시 $LOTTO_NUMBER_COUNT 개 입니다." }
        require(lottoNumbers.toSet().size == LOTTO_NUMBER_COUNT) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getLottoResultWith(otherLottoTicket: LottoTicket, bonusNumber: LottoNumber): LottoResult {
        val matchCount = this.lottoNumbers.count { otherLottoTicket.hasLottoNumber(it) }
        val hasBonusNumber = hasLottoNumber(bonusNumber)
        return LottoResult.findByMatchNumOf(matchCount, hasBonusNumber)
    }

    private fun hasLottoNumber(lottoNumber: LottoNumber): Boolean {
        return this.lottoNumbers
            .contains(lottoNumber)
    }

    override fun toString(): String {
        return this.lottoNumbers.toString()
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1_000
    }
}
