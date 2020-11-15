package lotto.domain

object LottoNumbersGenerator : NumbersGenerator {
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45
    private const val LOTTO_NUMBER_COUNT = 6

    private fun selectRandomNumber(lottoNumberCandidate: MutableList<Int>): Int {
        return lottoNumberCandidate.shuffled().last()
    }

    override fun generate(): List<Int> {
        val lottoNumberCandidate = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toMutableList()
        val lottoNumbers = mutableListOf<Int>()
        repeat(LOTTO_NUMBER_COUNT) {
            val selectedNumber = selectRandomNumber(lottoNumberCandidate)
            lottoNumbers.add(selectedNumber)
            lottoNumberCandidate.remove(selectedNumber)
        }
        return lottoNumbers.sorted()
    }
}
