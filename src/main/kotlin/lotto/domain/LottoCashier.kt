package lotto.domain

import lotto.domai.RandomNumGenerator

class LottoCashier(randomNumGenerator: RandomNumGenerator) {
    private val lottoTicketMachine = LottoTicketMachine(randomNumGenerator)

    fun calculateLottoCount(money: Money): Int {
        checkEnoughMoney(money)
        return money.value / LOTTO_PRICE
    }

    private fun checkEnoughMoney(money: Money) {
        require(money.value >= LOTTO_PRICE) {
            "로또 하나의 금액은 1000원입니다."
        }
    }

    fun getLotto(lottoCount: Int): List<LottoTicket> {
        return (1..lottoCount).map { lottoTicketMachine.make() }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
