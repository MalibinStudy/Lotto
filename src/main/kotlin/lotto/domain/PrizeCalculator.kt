package lotto.domain

object PrizeCalculator {
    private const val NO_PRIZE_MONEY = 0
    private const val THREE_MATCH_PRIZE_MONEY = 5000
    private const val FOUR_MATCH_PRIZE_MONEY = 50000
    private const val FIVE_MATCH_PRIZE_MONEY = 1500000
    private const val SIX_MATCH_PRIZE_MONEY = 2000000000
    private val matchCountToPrizeMoney =
        mapOf(
            0 to NO_PRIZE_MONEY,
            1 to NO_PRIZE_MONEY,
            2 to NO_PRIZE_MONEY,
            3 to THREE_MATCH_PRIZE_MONEY,
            4 to FOUR_MATCH_PRIZE_MONEY,
            5 to FIVE_MATCH_PRIZE_MONEY,
            6 to SIX_MATCH_PRIZE_MONEY
        )

    private fun getPrizeMoney(matchCount: Int): Int {
        return matchCountToPrizeMoney.getValue(matchCount)
    }

    fun getPrizeMoneySum(matchResults: List<Int>): Int {
        return matchResults.fold(0, { total, matchCount -> total + getPrizeMoney(matchCount) })
    }
}
