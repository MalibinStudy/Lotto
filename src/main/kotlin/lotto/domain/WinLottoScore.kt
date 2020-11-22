package lotto.domain

import java.lang.IllegalArgumentException
import kotlin.math.roundToInt

class WinLottoScore(
    private val score: MutableMap<WinLotto, Int> = mutableMapOf(
        WinLotto.THREE to 0,
        WinLotto.FOUR to 0,
        WinLotto.FIVE to 0,
        WinLotto.SIX to 0,
    )
) {
    fun getLottoCount(numberWinNumberCount: WinLotto): Int {
        return score[numberWinNumberCount] ?: throw IllegalArgumentException("입력은 LottoWinCount의 인스턴스여야 합니다.")
    }

    fun increaseLottoCount(numberWinNumberCount: WinLotto) {
        score[numberWinNumberCount] = score[numberWinNumberCount]!!.inc()
    }

    fun getProfitRate(money: Int): Double {
        val profiteRate = getTotalPrize() / money.toDouble()
        return (profiteRate * 100).roundToInt() / 100.0
    }

    private fun getTotalPrize(): Int {
        return score.entries.sumBy { it.key.prizeMoney * it.value }
    }
}
