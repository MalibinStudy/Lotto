package lotto.domain

import java.lang.IllegalArgumentException

enum class WinLotto(
    private val correctNum: Int,
    val winPrice: Int,
    val calculateWinPrice: (Int) -> Long
) {
    CORRECT_THREE(3, 5000, { num -> num * 5000L }),
    CORRECT_FOUR(4, 50000, { num -> num * 50000L }),
    CORRECT_FIVE(5, 1500000, { num -> num * 1500000L }),
    CORRECT_SIX(6, 2000000000, { num -> num * 2000000000L });

    private var winnerCount = 0
    fun setWinnerCount(count: Int) {
        winnerCount = count
    }

    fun getWinnerCount(): Int {
        return winnerCount
    }

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
