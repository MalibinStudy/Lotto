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

    fun buyLotto(lottoCount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) { requestLottoMaker(lottos) }
        return lottos
    }

    private fun requestLottoMaker(resultLottos: MutableList<Lotto>) {
        val lotto = LottoMaker.make()
        resultLottos.add(lotto)
    }
}
