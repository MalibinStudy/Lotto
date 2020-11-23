package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoNum
import lotto.domain.data.Money
import lotto.domain.data.Lottos

class LottoMachine {
    fun generateLottos(purchaseCost: Money, lottoNumGenerator: LottoNumGenerator): Lottos {
        val numOfLottos = purchaseCost.value / LOTTO_PRICE_UNIT
        return Lottos((1..numOfLottos).map { generateLotto(lottoNumGenerator.generateLottoNums()) })
    }

    fun generateLotto(lottoNums: Set<LottoNum>): Lotto {
        return Lotto(lottoNums)
    }

    companion object {
        const val LOTTO_PRICE_UNIT = 1000
    }
}
