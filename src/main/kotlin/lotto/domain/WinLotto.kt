package lotto.domain

import java.lang.IllegalArgumentException

enum class WinLotto(private val sameNumberCount: Int, val prizeMoney: Int) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private fun checkIfSameCount(count: Int): Boolean = this.sameNumberCount == count

    companion object {
        fun findInstance(winNumberCount: Int): WinLotto {
            return values().find {
                it.checkIfSameCount(winNumberCount)
            } ?: throw IllegalArgumentException("winNumberCount는 3, 4, 5, 6 중 하나여야 합니다.")
        }
    }
}
