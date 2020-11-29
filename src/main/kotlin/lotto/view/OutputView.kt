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

fun printBonusNumberRequest() {
    println("보너스 볼을 입력해 주세요.")
}

fun printLottoStatistics(lottoStatistics: LottoStatistics) {
    println("\n당첨 통계")
    println(CONSOLE_DIVEDER)
    LottoResult.values().reversedArray().forEach {
        printLottoResult(it, lottoStatistics.countWinningWith(it))
    }
}

private fun printLottoResult(result: LottoResult, count: Int) {
    if (result == LottoResult.LOSE) return
    if (result == LottoResult.SECOND) {
        println("5개 일치, 보너스 볼 일치(${result.prize} 원) - ${count}개")
    }
    println("${getMatchCount(result)}개 일치 (${result.prize}원) - ${count}개")
}

private fun getMatchCount(result: LottoResult): Int = when (result) {
    LottoResult.FIRST -> 6
    LottoResult.SECOND, LottoResult.THIRD -> 5
    LottoResult.FOURTH -> 4
    LottoResult.FIFTH -> 3
    LottoResult.LOSE -> 0
}

fun printRevenueRatio(ratio: BigDecimal) {
    println("총 수익률은 $ratio 입니다")
}
