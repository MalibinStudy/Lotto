package lotto.domain.data

data class Lotto(
    val lottoNums: Set<LottoNum>
) {
    init {
        require(lottoNums.size == LOTTO_ENTRY_NUM) { "로또 번호가 잘못 만들어졌어요 $lottoNums" }
    }

    fun getWinnerByCompare(otherLotto: Lotto, bonusNum: LottoNum): Rank {
        val correctNum = lottoNums.count { otherLotto.lottoNums.contains(it) }
        val isBonusCorrect = lottoNums.contains(bonusNum)
        return Rank.find(correctNum, isBonusCorrect)
    }

    override fun toString(): String {
        return lottoNums.joinToString { it.value.toString() }
    }

    companion object {
        const val LOTTO_ENTRY_NUM = 6
    }
}
