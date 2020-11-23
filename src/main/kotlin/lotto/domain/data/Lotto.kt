package lotto.domain.data

data class Lotto(
    val lottoNums: Set<LottoNum>
) {
    init {
        require(lottoNums.size == LOTTO_ENTRY_NUM) { "로또 번호가 잘못 만들어졌어요 $lottoNums" }
    }

    fun getWinnerByCompare(otherLotto: Lotto): LottoResult {
        val correctNum = lottoNums.count { otherLotto.lottoNums.contains(it) }
        return LottoResult.findByCorrectNum(correctNum)
    }

    override fun toString(): String { // 뷰에 보여주기 위해 로직이 들어간 느낌
        return lottoNums.map { it.value }.toString()
    }

    companion object {
        const val LOTTO_ENTRY_NUM = 6
    }
}
