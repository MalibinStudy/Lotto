package lotto.domain

import java.util.EnumMap
import kotlin.math.roundToInt

class WinLottoStatistics(
    private val count: EnumMap<WinLottoTicket, Int> = EnumMap(WinLottoTicket::class.java)
) {

    fun getLottoCount(winLottoTicket: WinLottoTicket): Int? {
        return count[winLottoTicket]
    }

    fun increaseLottoCount(numberWinNumberCountTicket: WinLottoTicket) {
        if (count[numberWinNumberCountTicket] == null) {
            count[numberWinNumberCountTicket] = 0
        }
        count[numberWinNumberCountTicket] = count[numberWinNumberCountTicket]?.inc()
    }

    fun decreaseLottoCount(numberWinNumberCountTicket: WinLottoTicket) {
        if (count[numberWinNumberCountTicket] == null) {
            count[numberWinNumberCountTicket] = 0
        }
        count[numberWinNumberCountTicket] = count[numberWinNumberCountTicket]?.dec()
    }

    fun getProfitRate(money: Money): Double {
        val profiteRate = getTotalPrize() / money.value.toDouble()
        return (profiteRate * 100).roundToInt() / 100.0
    }

    private fun getTotalPrize(): Int {
        return count.entries.sumBy { statistics -> statistics.key.prizeMoney.value * statistics.value }
    }
}
