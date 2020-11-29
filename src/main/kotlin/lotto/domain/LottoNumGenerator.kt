package lotto.domain

import lotto.domain.data.LottoNum

class LottoNumGenerator {
    private val lottoNums = (LottoNum.MINIMUM_LOTTO_NUM..LottoNum.MAXIMUM_LOTTO_NUM).map { LottoNum.valueOf(it) }

    fun generateLottoNums(): Set<LottoNum> {
        return lottoNums
            .shuffled()
            .take(VALID_SIZE)
            .sortedBy { it.value }
            .toSet()
    }

    companion object {
        const val VALID_SIZE = 6
    }
}
