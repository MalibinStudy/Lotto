package lotto.domain

object LottoNumGenerator {
    fun getGeneratedLottoNums(): List<Int> {
        return generateRandomNums().take(LOTTO_ENTRY_NUM)
    }

    private fun generateRandomNums(): List<Int> {
        return (MINIMUM_LOTTO_NUM..MAXIMUM_LOTTO_NUM).shuffled()
    }

    private const val MINIMUM_LOTTO_NUM = 1
    private const val MAXIMUM_LOTTO_NUM = 45
    private const val LOTTO_ENTRY_NUM = 6
}
