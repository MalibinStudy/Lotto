package lotto.domain.data

enum class Rank(
    val correctNum: Int,
    val winPrice: Int,
    val calculateProfit: (Int) -> Double
) {
    FIRST(6, 2_000_000_000, { winnerCount -> winnerCount * 2_000_000_000.00 }),
    SECOND(5, 30_000_000, { winnerCount -> winnerCount * 30_000_000.00 }),
    THIRD(5, 1_500_000, { winnerCount -> winnerCount * 1_500_000.00 }),
    FOURTH(4, 50_000, { winnerCount -> winnerCount * 50_000.00 }),
    FIFTH(3, 5_000, { winnerCount -> winnerCount * 5_000.00 }),
    MISS(0, 0, { 0.00 });

    private fun hasCorrectNum(correctNum: Int): Boolean {
        return this.correctNum == correctNum
    }

    companion object {
        fun find(correctNum: Int, isBonusCorrect: Boolean): Rank {
            if (correctNum == 5) {
                if (isBonusCorrect) return SECOND
                return THIRD
            }
            return values().find { it.hasCorrectNum(correctNum) } ?: MISS
        }
    }
}
