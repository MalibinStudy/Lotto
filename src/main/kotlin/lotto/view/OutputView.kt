package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinLottoScore
import lotto.domain.WinLotto

object OutputView {
    fun printLottoCount(lottoCount: Int) {
        println("$lottoCount 개를 구매했습니다.")
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.map { println(it.numbers) }
        println()
    }

    fun printLottoScore(winLottoScore: WinLottoScore) {
        println("\n당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${winLottoScore.getLottoCount(WinLotto.THREE)}")
        println("4개 일치 (50000원)- ${winLottoScore.getLottoCount(WinLotto.FOUR)}")
        println("5개 일치 (1500000원)- ${winLottoScore.getLottoCount(WinLotto.FIVE)}")
        println("6개 일치 (2000000000원)- ${winLottoScore.getLottoCount(WinLotto.FOUR)}")
    }

    fun printProfitRate(profitRate: Double) {
        print("총 수익률은 $profitRate 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
