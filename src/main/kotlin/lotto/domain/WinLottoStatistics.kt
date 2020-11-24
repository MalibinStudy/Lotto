package lotto.domain

import java.util.EnumMap
import kotlin.math.roundToInt

class WinLottoStatistics(
    private val count: EnumMap<WinLotto, Int> = EnumMap(WinLotto::class.java)
) {
    init {
        count[WinLotto.THREE] = 0
        count[WinLotto.FOUR] = 0
        count[WinLotto.FIVE] = 0
        count[WinLotto.SIX] = 0
    }

    fun getLottoCount(numberWinNumberCount: WinLotto): Int {
        return count[numberWinNumberCount] ?: throw IllegalArgumentException("입력은 WinLotto의 인스턴스여야 합니다.")
    }

    fun increaseLottoCount(numberWinNumberCount: WinLotto) {
        count[numberWinNumberCount] = count[numberWinNumberCount]!!.inc()
    }

    fun getProfitRate(money: Money): Double {
        val profiteRate = getTotalPrize() / money.value.toDouble()
        return (profiteRate * 100).roundToInt() / 100.0
    }

    private fun getTotalPrize(): Int {
        return count.entries.sumBy { statistics -> statistics.key.prizeMoney.value * statistics.value }
    }
}
