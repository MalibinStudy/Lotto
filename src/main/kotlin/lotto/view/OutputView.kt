package lotto.view

import lotto.domain.LottoBundle
import lotto.domain.PrizeCheckList

object OutputView {
    fun printMyLottoResult(prizeCheckList: PrizeCheckList) {
        val lottoResult = prizeCheckList.getWinningResult()
        println("결과 통계")
        println("3개 일치: ${lottoResult.getFifthPrizeCount()}개")
        println("4개 일치: ${lottoResult.getForthPrizeCount()}개")
        println("5개 일치: ${lottoResult.getThirdPrizeCount()}개")
        println("5개 일치, 보너스 볼 일치: ${lottoResult.getSecondPrizeCount()}개")
        println("6개 일치: ${lottoResult.getFirstPrizeCount()}개")
    }

    fun printMyGainRate(money: Int, prizeCheckList: PrizeCheckList) {
        val myPrize = prizeCheckList.getMoney()
        println("총 수익률은 ${String.format("%.2f", myPrize.sum() / money.toDouble())}입니다.")
    }

    fun printMyLotto(lottoBundle: LottoBundle) {
        for (lottoTicket in lottoBundle.lottoTickets) {
            println(lottoTicket)
        }
    }
}
