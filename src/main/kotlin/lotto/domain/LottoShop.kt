package lotto.domain

class LottoShop {
    fun purchaseLottos(purchasePrice: Int): List<Lotto> {
        val numOfLottos = purchasePrice / LOTTO_PRICE_UNIT
        return List(numOfLottos) { generateLottos(LottoNumGenerator.getGeneratedLottoNums()) }
    }

    private fun generateLottos(lottoNums: List<Int>): Lotto {
        return Lotto(lottoNums)
    }

    companion object {
        const val LOTTO_PRICE_UNIT = 1000
    }
}
