package lotto.domain

object LottoCashier {
    private const val LOTTO_PRICE = 1000

    fun calculateLottoCount(money: Int): Int {
        checkEnoughMoney(money)
        return money / LOTTO_PRICE
    }

    private fun checkEnoughMoney(money: Int) {
        require(money >= LOTTO_PRICE) {
            "로또 하나의 금액은 1000원입니다."
        }
    }

    fun getLotto(lottoCount: Int): List<Lotto> {
        return (1..lottoCount).map { LottoMaker.make() }
    }
}
