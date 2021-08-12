package lotto.domain

class PrizeCheckList(val prizeCheckList: List<Rank>) {
    fun getMoney(): List<Long> = this.prizeCheckList.map { it.getLottoMoney() }

    fun getWinningResult(): WinResult {
        val lottoBundleResult = mutableListOf<Int>()
        lottoBundleResult.add(prizeCheckList.count { it == Rank.LOSING_TICKET })
        lottoBundleResult.add(prizeCheckList.count { it == Rank.FIFTH_PRIZE_TICKET })
        lottoBundleResult.add(prizeCheckList.count { it == Rank.FOURTH_PRIZE_TICKET })
        lottoBundleResult.add(prizeCheckList.count { it == Rank.THIRD_PRIZE_TICKET })
        lottoBundleResult.add(prizeCheckList.count { it == Rank.SECOND_PRIZE_TICKET })
        lottoBundleResult.add(prizeCheckList.count { it == Rank.FIRST_PRIZE_TICKET })
        return WinResult(lottoBundleResult.toList())
    }
}
