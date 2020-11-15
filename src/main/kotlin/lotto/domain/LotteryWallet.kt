package lotto.domain

import lotto.domain.DrawingMachine.Companion.LOTTO_NUMBER_END
import lotto.domain.DrawingMachine.Companion.LOTTO_NUMBER_START

class LotteryWallet(private val myMoney: Int) {
    private val lotteryWallet = mutableListOf<LottoNumber>()

    init {
        Validation.validatePrice(myMoney)
        val drawingMachine = DrawingMachine(LOTTO_NUMBER_START, LOTTO_NUMBER_END)
        repeat(myMoney / LOTTO_UNIT_PRICE) {
            buyLotto(drawingMachine.getLottoList(DrawingMachine.LOTTO_LENGTH))
        }
    }

    private fun buyLotto(lotto: LottoNumber) {
        lotteryWallet.add(lotto)
    }

    fun getMyLotto(): List<LottoNumber> = lotteryWallet.toList()

    fun getMyMoney() = myMoney

    companion object {
        const val LOTTO_UNIT_PRICE = 1000
    }
}