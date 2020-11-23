package lotto.view

import lotto.domain.data.Lottos
import lotto.domain.data.WinResults

class ResultView {
    fun showLottos(purchasedLottos: Lottos) {
        val lottos = purchasedLottos.lottos
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.toString()) }
        print("\n")
    }

    fun showWinStatistics(winResult: WinResults) {
        println("\n당첨 통계\n--------")
        winResult.result.forEach { (winLotto, winnerCount) ->
            val correctNum = winLotto.correctNum
            val winPrice = winLotto.winPrice
            println("${correctNum}개 일치 (${winPrice}원)- ${winnerCount}개")
        }
    }

    fun showProfitRatio(profitRatio: Double) {
        println("총 수익률은 ${profitRatio}입니다.")
    }
}
