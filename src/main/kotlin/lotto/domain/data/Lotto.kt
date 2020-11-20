package lotto.domain.data

data class Lotto(
    private val lottoNums: Set<LottoNum>
) {
    init {
        require(lottoNums.size == LOTTO_ENTRY_NUM) { "로또 번호가 잘못 만들어졌어요 $lottoNums" }
    }

    fun getWinnerByCompare(otherLotto: Lotto): WinLotto? {
        val correctNum = lottoNums.count { otherLotto.lottoNums.contains(it) }
        if (correctNum >= MIN_CORRECT_NUM) {
            return WinLotto.findByCorrectNum(correctNum)
        }
        return null
    }

    override fun toString(): String {
        return lottoNums.map { it.getLottoNum() }.toString()
    }

    companion object {
        const val LOTTO_ENTRY_NUM = 6
        const val MIN_CORRECT_NUM = 3
    }
}
