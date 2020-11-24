package lotto.domain

enum class LotteryWinningCriteria(
    private val numberOfWins: Int,
    private val lottoPrizePolicy: LottoPrizePolicy
) {
    LOSING_TICKET(0, LottoPrizePolicy { NO_PRIZE }),
    FOURTH_PRIZE_TICKET(3, LottoPrizePolicy { FOURTH_PRIZE }),
    THIRD_PRIZE_TICKET(4, LottoPrizePolicy { THIRD_PRIZE }),
    SECOND_PRIZE_TICKET(5, LottoPrizePolicy { SECOND_PRIZE }),
    FIRST_PRIZE_TICKET(6, LottoPrizePolicy { FIRST_PRIZE });

    fun isWin(winningNumber: Int): Boolean {
        return this.numberOfWins == winningNumber
    }

    fun getLottoMoney(): Long {
        return this.lottoPrizePolicy.setLottoPrize()
    }

    companion object {
        fun checkLottoPrize(winningNumber: Int): LotteryWinningCriteria {
            return values().find { it.isWin(winningNumber) } ?: LOSING_TICKET
        }
        const val NO_PRIZE = 0L
        const val FOURTH_PRIZE = 5_000L
        const val THIRD_PRIZE = 50_000L
        const val SECOND_PRIZE = 1_500_000L
        const val FIRST_PRIZE = 2_000_000_000L
    }
}
