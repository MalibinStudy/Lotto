package lotto.domain

object LottoMaker {
    val LOTTO_NUMBER_RANGE = IntRange(1, 45)
    val LOTTO_NUMBER_START_INDEX = 0
    val LOTTO_LENGTH = 6

    fun make(): Lotto {
        val lottoNumbers = LOTTO_NUMBER_RANGE.shuffled()
            .subList(LOTTO_NUMBER_START_INDEX, LOTTO_LENGTH)
        return Lotto(lottoNumbers)
    }
}
