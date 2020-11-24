package lotto.domain

class AutoNumberCreator() {

    fun createEveryLotto(countOfLotto: Int): List<List<Int>> {
        var everyLottoList = mutableListOf<List<Int>>()
        repeat(countOfLotto) {
            val lottoNumber = createAutoNumber()
            everyLottoList.add(lottoNumber)
        }
        return everyLottoList
    }

    private fun createAutoNumber(): List<Int> {
        return NUMBER_RANGE.shuffled().take(COUNT_OF_LOTTO_NUMBER).sorted()
    }

    companion object {
        private val NUMBER_RANGE = 1..46
        private const val COUNT_OF_LOTTO_NUMBER = 6
    }
}
