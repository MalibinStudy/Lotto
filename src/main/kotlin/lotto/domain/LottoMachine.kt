package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.Money
import lotto.domain.data.Lottos

class LottoMachine {
    fun generateLottos(purchaseCost: Money, lottoNumGenerator: LottoNumGenerator): Lottos {
        val numOfLottos = purchaseCost.getNumOfBuy(LOTTO_PRICE_UNIT)
        return Lottos((1..numOfLottos).map { Lotto(lottoNumGenerator.generateLottoNums()) })
    }

    companion object {
        const val LOTTO_PRICE_UNIT = 1000
    }
}
