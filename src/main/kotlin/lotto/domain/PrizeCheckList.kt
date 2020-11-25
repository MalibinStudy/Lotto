package lotto.domain

class PrizeCheckList(val prizeCheckList: List<LotteryWinningCriteria>) {
    fun getMoney(): List<Long> = this.prizeCheckList.map { it.getLottoMoney() }

    fun getWinningResult(): List<Int> {
        val countResult = mutableListOf<Int>()
        checkWinningCount(countResult)
        return countResult.toList()
    }

    private fun checkWinningCount(result: MutableList<Int>) {
        result.add(prizeCheckList.count { it == LotteryWinningCriteria.LOSING_TICKET })
        result.add(prizeCheckList.count { it == LotteryWinningCriteria.FOURTH_PRIZE_TICKET })
        result.add(prizeCheckList.count { it == LotteryWinningCriteria.THIRD_PRIZE_TICKET })
        result.add(prizeCheckList.count { it == LotteryWinningCriteria.SECOND_PRIZE_TICKET })
        result.add(prizeCheckList.count { it == LotteryWinningCriteria.FIRST_PRIZE_TICKET })
    }
}
