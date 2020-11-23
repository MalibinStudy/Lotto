package lotto.domain

import lotto.domain.data.LottoNum

class LottoNumGenerator {
    fun generateLottoNums(): Set<LottoNum> {
        val lottoNums = LottoNum.cache.shuffled()
        return lottoNums
            .take(VALID_SIZE)
            .sortedBy { it.value }
            .toSet()
    }

    companion object {
        const val VALID_SIZE = 6
    }
}
