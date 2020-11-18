package lotto.domain

class LottoShop {
    fun purchaseLottos(purchasePrice: Int): List<Lotto> {
        val numOfLottos = purchasePrice / LOTTO_PRICE_UNIT
        return List(numOfLottos) { generateLottos() }
    }

    private fun generateLottos(): Lotto {
        return Lotto(LottoNumGenerator.getGeneratedLottoNums())
    }

    companion object {
        const val LOTTO_PRICE_UNIT = 1000
    }
}
