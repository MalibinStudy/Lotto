package lotto.domain

class Lotto {
    private var lottoNums = listOf<Int>()

    fun createLottoNums() {
        lottoNums = (1..45).shuffled()
            .take(LOTTO_ENTRY_NUM)
    }

    fun getLottoNums(): List<Int> {
        return lottoNums
    }

    companion object {
        const val LOTTO_ENTRY_NUM = 6
    }
}
