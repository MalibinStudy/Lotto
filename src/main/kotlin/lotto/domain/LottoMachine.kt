package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.Lotto.Companion.LOTTO_ENTRY_NUM
import lotto.domain.data.Lottos
import lotto.domain.data.Money

class LottoMachine(private val lottoNumGenerator: LottoNumGenerator) {
    fun generatedLottos(purchaseCost: Money): Lottos {
        val numOfLottos = purchaseCost.getValue() / LOTTO_PRICE_UNIT
        return Lottos(List(numOfLottos) { generateLotto() })
    }

    private fun generateLotto(): Lotto {
        val shuffledLottoNums = lottoNumGenerator.generateRandomNums()
        val lottoNums = shuffledLottoNums.take(LOTTO_ENTRY_NUM)
            .sortedBy { it.getLottoNum() }
            .toSet()
        return Lotto(lottoNums)
    }

    companion object {
        const val LOTTO_PRICE_UNIT = 1000
    }
}
