package lotto.domain

class WinningStatistics(
    private val statistics: MutableMap<Int, Int> = mutableMapOf(
        FIRST_PRIZE to 0,
        SECOND_PRIZE to 0,
        THIRD_PRIZE to 0,
        FOURTH_PRIZE to 0,
    )
) {
    fun increase(matchNumberCount: Int) {
        when (matchNumberCount) {
            3 -> statistics[FOURTH_PRIZE] = statistics[FOURTH_PRIZE]!! + PLUS_COUNT
            4 -> statistics[THIRD_PRIZE] = statistics[THIRD_PRIZE]!! + PLUS_COUNT
            5 -> statistics[SECOND_PRIZE] = statistics[SECOND_PRIZE]!! + PLUS_COUNT
            6 -> statistics[FIRST_PRIZE] = statistics[FIRST_PRIZE]!! + PLUS_COUNT
            else -> {
            }
        }
    }

    fun getStatistics(): Map<Int, Int> {
        return statistics.toMap()
    }

    fun getTotalPrize(): Double {
        var totalPrizeMoney = 0
        statistics.forEach { (prize, value) ->
            totalPrizeMoney += prize * value
        }
        return totalPrizeMoney.toDouble()
    }

    companion object {
        private const val PLUS_COUNT = 1
        const val FIRST_PRIZE = 2000000000
        const val SECOND_PRIZE = 1500000
        const val THIRD_PRIZE = 50000
        const val FOURTH_PRIZE = 5000
    }
}
