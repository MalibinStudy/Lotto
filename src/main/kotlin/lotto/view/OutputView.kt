package lotto.view

import lotto.domain.LottoBundle
import lotto.domain.PrizeCheckList

object OutputView {
    fun printMyLottoResult(prizeCheckList: PrizeCheckList) {
        val lottoResult = prizeCheckList.getWinningResult()
        println("결과 통계")
        for (index in 3..6) {
            println("${index}개 일치: ${lottoResult[index - 2]}")
        }
    }

    fun printMyGainRate(money: Int, prizeCheckList: PrizeCheckList) {
        val myPrize = prizeCheckList.getMoney()
        println("총 수익률은 ${String.format("%.2f", myPrize.sum() / money.toDouble())}입니다.")
    }

    fun printMyLotto(lottoBundle: LottoBundle) {
        for(lottoTicket in lottoBundle.lottoTickets) {
            println(lottoTicket)
        }
    }
}
