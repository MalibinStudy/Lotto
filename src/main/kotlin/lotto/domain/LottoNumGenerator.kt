package lotto.domain

import lotto.domain.data.LottoNum
import lotto.domain.data.LottoNum.Companion.MAXIMUM_LOTTO_NUM
import lotto.domain.data.LottoNum.Companion.MINIMUM_LOTTO_NUM

class LottoNumGenerator {
    private val lottoNumRange = MINIMUM_LOTTO_NUM..MAXIMUM_LOTTO_NUM

    fun generateRandomNums(): List<LottoNum> {
        return lottoNumRange.map { LottoNum(it) }
            .shuffled()
    }
}
