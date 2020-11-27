package lotto.domain

import java.util.EnumMap
import kotlin.math.roundToInt

class WinLottoStatistics(
    private val count: EnumMap<WinLottoTicket, Int> = EnumMap(WinLottoTicket::class.java)
) {
    init {
        count[WinLottoTicket.THREE] = 0
        count[WinLottoTicket.FOUR] = 0
        count[WinLottoTicket.FIVE] = 0
        count[WinLottoTicket.SIX] = 0
    }

    fun getLottoCount(numberWinNumberCountTicket: WinLottoTicket): Int {
        return count[numberWinNumberCountTicket] ?: throw IllegalArgumentException("입력은 WinLotto의 인스턴스여야 합니다.")
    }

    fun increaseLottoCount(numberWinNumberCountTicket: WinLottoTicket) {
        count[numberWinNumberCountTicket] = count[numberWinNumberCountTicket]!!.inc()
    }

    fun getProfitRate(money: Money): Double {
        val profiteRate = getTotalPrize() / money.value.toDouble()
        return (profiteRate * 100).roundToInt() / 100.0
    }

    private fun getTotalPrize(): Int {
        return count.entries.sumBy { statistics -> statistics.key.prizeMoney.value * statistics.value }
    }
}
