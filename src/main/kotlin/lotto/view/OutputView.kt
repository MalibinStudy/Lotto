package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.WinLottoStatistics
import lotto.domain.WinLottoTicket

object OutputView {
    fun printLottoCount(lottoCount: Int) {
        println("$lottoCount 개를 구매했습니다.")
    }

    fun printLottos(lottoTickets: LottoTickets) {
        print(lottoTickets.toString())
        println()
    }

    fun printLottoScore(winLottoStatistics: WinLottoStatistics) {
        println("\n당첨 통계")
        println("---------")
        println("3개 일치 (5000원) - ${winLottoStatistics.getLottoCount(WinLottoTicket.THREE) ?: 0}")
        println("4개 일치 (50000원) - ${winLottoStatistics.getLottoCount(WinLottoTicket.FOUR) ?: 0} ")
        println("5개 일치 (1500000원) - ${winLottoStatistics.getLottoCount(WinLottoTicket.FIVE) ?: 0} ")
        println("5개 일치, 보너스 볼 일치(30000000원) - ${winLottoStatistics.getLottoCount(WinLottoTicket.FIVE_WITH_BONUS) ?: 0}")
        println("6개 일치 (2000000000원) - ${winLottoStatistics.getLottoCount(WinLottoTicket.SIX) ?: 0}")
    }

    fun printProfitRate(profitRate: Double) {
        print("총 수익률은 $profitRate 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
