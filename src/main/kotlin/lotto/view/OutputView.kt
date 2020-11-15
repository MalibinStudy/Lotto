package lotto.view

import lotto.domain.LotteryWallet
import lotto.domain.WinningResult

object OutputView {
    fun printAllOfMyLotto(lotteryWallet: LotteryWallet) {
        val myLottoList = lotteryWallet.getMyLotto()
        println("${myLottoList.size}개를 구매하셨습니다.")
        for (lottoNumber in myLottoList) {
            println(lottoNumber.getLotto())
        }
        println(BLANK)
    }

    fun showMyResult(winningResult: WinningResult, lotteryWallet: LotteryWallet) {
        val myWinningResult = winningResult.checkMyLotto(lotteryWallet)
        val lottoPrize: List<Long> = listOf(FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE)
        val myPrizeResult = mutableListOf<Int>()

        var myWinningPrize = 0L

        for (index in 3..6) {
            myPrizeResult.add(myWinningResult.filter { it == index }.size)
        }

        for (index in lottoPrize.indices) {
            myWinningPrize += myPrizeResult[index] * lottoPrize[index]
        }

        println("당첨 통계")
        println("================")
        repeat(myPrizeResult.size) {
            println("${it + 3}개 일치 (${lottoPrize[it]}원): ${myPrizeResult[it]}개")
        }

        println("총 수익률은 ${myWinningPrize.toDouble() / lotteryWallet.getMyMoney()}입니다.")
    }


    private const val FIRST_PRIZE = 2000000000L
    private const val SECOND_PRIZE = 1500000L
    private const val THIRD_PRIZE = 50000L
    private const val FOURTH_PRIZE = 5000L

    private const val BLANK = ""
}
