package lotto.domain

class LottoNumberRepository {
    private val lottoNumber = (LOTTO_START_NUMBER..LOTTO_END_NUMBER).toList()

    fun getRandomLotto(): List<Int> {
        return lottoNumber.shuffled().take(LOTTO_NUMBER_COUNT).sorted()
    }

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
