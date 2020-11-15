package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.WinningStatics

object OutputView {
    private const val LOSS = "손해"
    private const val GAIN = "이득"
    private const val DELIMITER = ","

    fun printPurchaseTicketCount(TicketCount: Int) {
        println("${TicketCount}개를 구매했습니다.")
    }

    fun printLottoTickets(lottoTickets: LottoTickets) {
        lottoTickets.lottoTickets.forEach { printLottoTicket(it) }
    }

    private fun printLottoTicket(lottoTicket: LottoTicket) {
        println("[${lottoTicket.lottoTicket.joinToString(separator = DELIMITER)}]")
    }

    fun printWinningStatics(statics: WinningStatics) {
        println("당첨통계\n---------")
        printWinningResult(statics.winningResult)
        printRateOfProfit(statics.rateOfProfit)
        printOutcome(statics.isLoss)
    }

    private fun printWinningResult(winningResult: List<Int>) {
        println("3개 일치 (5000원)- ${winningResult.count { it == 3 }}개")
        println("4개 일치 (50000원)- ${winningResult.count { it == 4 }}개")
        println("5개 일치 (1500000원)- ${winningResult.count { it == 5 }}개")
        println("6개 일치 (2000000000원)- ${winningResult.count { it == 6 }}개")
    }

    private fun printRateOfProfit(rateOfProfit: Float) {
        print("총 수익률은 ${rateOfProfit}입니다. ")
    }

    private fun printOutcome(isLoss: Boolean) {
        val outcome = if (isLoss) LOSS else GAIN
        println("기준이 1이기 때문에 결과적으로 ${outcome}라는 의미임")
    }
}
