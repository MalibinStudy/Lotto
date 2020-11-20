package lotto.domain.data

import java.lang.IllegalArgumentException

enum class WinLotto(
    private val correctNum: Int,
    val winPrice: Int
) {
    CORRECT_THREE(3, 5_000),
    CORRECT_FOUR(4, 50_000),
    CORRECT_FIVE(5, 1_500_000),
    CORRECT_SIX(6, 2_000_000_000);

    private fun hasCorrectNum(correctNum: Int): Boolean {
        return this.correctNum == correctNum
    }

    fun getCorrectNum(): Int {
        return this.correctNum
    }

    companion object {
        fun findByCorrectNum(correctNum: Int): WinLotto {
            return values().find { it.hasCorrectNum(correctNum) } ?: throw IllegalArgumentException("당첨 이력이 없습니다.\n요청한 값: $correctNum")
        }
    }
}
