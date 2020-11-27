package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.ProfitCalculator
import lotto.domain.WinningResult
import java.math.BigDecimal

object OutputView {
    private const val DELIMITER = ","

    fun printPurchaseTicketCount(TicketCount: Int) {
        println("${TicketCount}개를 구매했습니다.")
    }

    fun printLottoTickets(lottoTickets: LottoTickets) {
        lottoTickets.lottoTickets.forEach { printLottoTicket(it) }
    }

    private fun printLottoTicket(lottoTicket: LottoTicket) {
        println("[${lottoTicket.lottoNumbers.joinToString(separator = DELIMITER)}]")
    }

    fun printWinningStatistics(winningResults: List<WinningResult>, purchaseMoney: Int) {
        println("당첨통계\n---------")
        printWinningResult(winningResults)
        printRateOfProfit(ProfitCalculator.getProfit(winningResults, purchaseMoney))
    }

    private fun printWinningResult(winningResult: List<WinningResult>) {
        println("3개 일치 (5000원)- ${winningResult.count { it == WinningResult.EQUAL_THREE }}개")
        println("4개 일치 (50000원)- ${winningResult.count { it == WinningResult.EQUAL_FOUR }}개")
        println("5개 일치 (1500000원)- ${winningResult.count { it == WinningResult.EQUAL_FIVE }}개")
        println("6개 일치 (2000000000원)- ${winningResult.count { it == WinningResult.EQUAL_SIX }}개")
    }

    private fun printRateOfProfit(rateOfProfit: BigDecimal) {
        print("총 수익률은 ${rateOfProfit}입니다. ")
        val outcome = if (rateOfProfit < BigDecimal(1.00)) "손해" else "이익"
        println("기준이 1이기 때문에 결과적으로 ${outcome}라는 의미임")
    }
}
