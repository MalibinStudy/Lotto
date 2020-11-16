package lotto.view

import lotto.domain.WinLotto

class ResultView {
    fun showWinProfit(winLotto: List<WinLotto>, profitRatio: Double) {
        println("\n당첨 통계\n--------")
        for (i in winLotto.indices) {
            val correctNum = winLotto[i].getCorrectNum()
            val winPrice = winLotto[i].winPrice
            val winnerNum = winLotto[i].getWinnerCount()
            println("${correctNum}개 일치 (${winPrice}원)- ${winnerNum}개")
        }
        println("총 수익률은 ${profitRatio}입니다.")
    }
}
