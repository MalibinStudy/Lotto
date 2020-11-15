package lotto.domain

class LottoVendingMachine {
    private val lottoNumberRepository = LottoNumberRepository()

    fun purchaseLotto(amount: Int): List<Lotto> {
        val infomationOnLottoPurchased = mutableListOf<Lotto>()
        repeat(amount / LOTTO_PRICE) {
            infomationOnLottoPurchased.add(Lotto(lottoNumberRepository.getRandomLotto()))
        }
        return infomationOnLottoPurchased.toList()
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
