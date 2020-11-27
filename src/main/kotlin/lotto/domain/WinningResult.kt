package lotto.domain

import java.lang.IllegalArgumentException

enum class WinningResult(
    private val equalCount: Int,
    val prize: Int
) {
    EQUAL_SIX(6, 2_000_000_000),
    EQUAL_FIVE(5, 1_500_000),
    EQUAL_FOUR(4, 50_000),
    EQUAL_THREE(3, 5_000),
    EQUAL_TWO(2, 0),
    EQUAL_ONE(1, 0),
    EQUAL_ZERO(0, 0);

    fun matchEqualCount(otherEqualCount: Int): Boolean {
        return this.equalCount == otherEqualCount
    }

    companion object {
        fun findByEqualCount(equalCount: Int): WinningResult {
            return values().find { it.matchEqualCount(equalCount) }
                ?: throw IllegalArgumentException("$equalCount 은 0 과 6 사이의 값이어야 합니다.")
        }
    }
}
