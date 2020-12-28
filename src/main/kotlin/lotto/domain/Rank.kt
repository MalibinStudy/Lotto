package lotto.domain

enum class Rank(
    private val numberOfWins: Int,
    val lottoPrize: Long
) {
    LOSING_TICKET(0, 0L),
    FIFTH_PRIZE_TICKET(3, 5_000L),
    FOURTH_PRIZE_TICKET(4, 50_000L),
    THIRD_PRIZE_TICKET(5, 1_500_000L),
    SECOND_PRIZE_TICKET(5, 30_000_000L),
    FIRST_PRIZE_TICKET(6, 2_000_000_000L);

    fun matchCount(winningNumber: Int): Boolean {
        return this.numberOfWins == winningNumber
    }

    fun getLottoMoney(): Long {
        return this.lottoPrize
    }

    companion object {
        fun checkLottoPrize(lottoResult: LottoResult): Rank {
            return if (lottoResult.matchCount == 5) {
                if (lottoResult.matchBonusNumber) SECOND_PRIZE_TICKET else THIRD_PRIZE_TICKET
            } else {
                values().find { it.matchCount(lottoResult.matchCount) } ?: LOSING_TICKET
            }
        }
    }
}
