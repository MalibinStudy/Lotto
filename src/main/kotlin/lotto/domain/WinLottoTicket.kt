package lotto.domain

import java.lang.IllegalArgumentException

enum class WinLottoTicket(private val sameNumberCount: Int, val prizeMoney: Money) {
    THREE(3, Money(5_000)),
    FOUR(4, Money(50_000)),
    FIVE(5, Money(1_500_000)),
    SIX(6, Money(2_000_000_000));

    private fun checkIfSameCount(count: Int): Boolean = this.sameNumberCount == count

    companion object {
        fun findInstance(winNumberCount: Int): WinLottoTicket {
            return values().find {
                it.checkIfSameCount(winNumberCount)
            } ?: throw IllegalArgumentException("winNumberCount는 3, 4, 5, 6 중 하나여야 합니다.")
        }
    }
}
