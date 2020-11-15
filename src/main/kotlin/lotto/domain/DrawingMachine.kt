package lotto.domain

class DrawingMachine(start: Int, end: Int) {
    private val lottoSampleSpace: List<Int> = (start..end).toList()

    init {
        Validation.validateRangeInputs(start, end)
    }

    fun getLottoList(length: Int): LottoNumber = LottoNumber(
        lottoSampleSpace
            .shuffled()
            .take(length)
            .sorted()
    )

    companion object {
        const val LOTTO_LENGTH = 6
        const val LOTTO_NUMBER_START = 1
        const val LOTTO_NUMBER_END = 45
    }
}
