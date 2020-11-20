package lotto.view

import lotto.domain.data.Lottos
import lotto.domain.data.WinLotto
import java.util.EnumMap

class ResultView {
    fun showLottos(purchasedLottos: Lottos) {
        val lottos = purchasedLottos.getLottos()
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.toString()) }
        print("\n")
    }

    fun showWinStatistics(winLotto: EnumMap<WinLotto, Int>) {
        println("\n당첨 통계\n--------")
        winLotto.forEach { (winLotto, winnerCount) ->
            val correctNum = winLotto.getCorrectNum()
            val winPrice = winLotto.winPrice
            println("${correctNum}개 일치 (${winPrice}원)- ${winnerCount}개")
        }
    }

    fun showProfitRatio(profitRatio: Double) {
        println("총 수익률은 ${profitRatio}입니다.")
    }
}
