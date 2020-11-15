package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningStatistics
import java.math.BigDecimal

private const val CONSOLE_DIVEDER = "------------------------"

fun printPurchaseAmountReqeust() {
    println("구입금액을 입력해주세요")
}

fun printInfomationOnLottoPurchased(lottoNumbers: List<Lotto>) {
    println("${lottoNumbers.size}개 구매했습니다.")
    lottoNumbers.forEach {
        println(it.lottoNumbers)
    }
    println(CONSOLE_DIVEDER)
}

fun printLastWeekWinningNumbersReqeust() {
    println("지난 주 당첨 번호를 입력해 주세요.")
}

fun printWinningStatistics(winningStatistics: WinningStatistics) {
    println("\n당첨 통계")
    println(CONSOLE_DIVEDER)
    println("3개 일치 (${WinningStatistics.FOURTH_PRIZE}원)- ${winningStatistics.getStatistics()[WinningStatistics.FOURTH_PRIZE]}개")
    println("4개 일치 (${WinningStatistics.THIRD_PRIZE}원)- ${winningStatistics.getStatistics()[WinningStatistics.THIRD_PRIZE]}개")
    println("5개 일치 (${WinningStatistics.SECOND_PRIZE}원)- ${winningStatistics.getStatistics()[WinningStatistics.SECOND_PRIZE]}개")
    println("6개 일치 (${WinningStatistics.FOURTH_PRIZE}원)- ${winningStatistics.getStatistics()[WinningStatistics.FOURTH_PRIZE]}개")
}

fun printRateOfReturn(rateOfReturn: Double) {
    println("총 수익률은 ${rateOfReturn.toBigDecimal().setScale(2, BigDecimal.ROUND_DOWN).toDouble()}입니다.")
}
