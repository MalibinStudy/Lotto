package lotto.view

import lotto.domain.data.Lottos
import lotto.domain.data.Rank
import lotto.domain.data.WinResults

class ResultView {
    fun showLottos(purchasedLottos: Lottos) {
        val lottos = purchasedLottos.lottos
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.toString()) }
        print("\n")
    }

    fun showWinStatistics(winResults: WinResults) {
        println("\n당첨 통계\n--------")
        winResults.result.forEach { (rank, winnerCount) ->
            printWins(rank, winnerCount)
        }
    }

    private fun printWins(rank: Rank, winnerCount: Int) {
        val correctNum = rank.correctNum
        val winPrice = rank.winPrice
        if (rank == Rank.SECOND) {
            println("${correctNum}개 일치, 보너스 볼 일치(${winPrice}원)- ${winnerCount}개")
            return
        }
        println("${correctNum}개 일치 (${winPrice}원)- ${winnerCount}개")
    }

    fun showProfitRatio(profitRatio: Double) {
        println("총 수익률은 ${profitRatio}입니다.")
    }
}
