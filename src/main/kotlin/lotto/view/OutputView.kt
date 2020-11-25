package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoStatistics
import lotto.domain.PurchasedLottoTickets
import java.math.BigDecimal

private const val CONSOLE_DIVEDER = "------------------------"

fun printPurchaseAmountReqeust() {
    println("구입금액을 입력해주세요")
}

fun printInfomationOnLottoPurchased(lottoTicketNumbers: PurchasedLottoTickets) {
    println("${lottoTicketNumbers.size}개 구매했습니다.")
    println(lottoTicketNumbers.toString())
    println(CONSOLE_DIVEDER)
}

fun printLastWeekWinningNumbersReqeust() {
    println("지난 주 당첨 번호를 입력해 주세요.")
}

fun printLottoStatistics(lottoStatistics: LottoStatistics) {
    println("\n당첨 통계")
    println(CONSOLE_DIVEDER)
    (3..6).forEach {
        printLottoResult(
            it,
            lottoStatistics.countWinningWith(findLottoResult(it))
        )
    }
}

private fun findLottoResult(matchCount: Int): LottoResult = LottoResult.findByMatchNumOf(matchCount)

private fun printLottoResult(matchCoutn: Int, count: Int) {
    println("${matchCoutn}개 일치 (${findLottoResult(matchCoutn).prize}원) - ${count}개")
}

fun printRevenueRatio(ratio: BigDecimal) {
    println("총 수익률은 $ratio 입니다")
}
