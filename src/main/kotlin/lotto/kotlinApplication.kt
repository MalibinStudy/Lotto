package lotto

import lotto.domain.LottoVendingMachine
import lotto.domain.LottoWinningChecker
import lotto.domain.RateOfReturn
import lotto.view.InputView
import lotto.view.printInfomationOnLottoPurchased
import lotto.view.printLastWeekWinningNumbersReqeust
import lotto.view.printPurchaseAmountReqeust
import lotto.view.printRateOfReturn
import lotto.view.printWinningStatistics

fun main() {
    printPurchaseAmountReqeust()
    val numberOfLotto = InputView.getLottoPurchasedCount()
    val lottoNumbers = LottoVendingMachine().purchaseLotto(numberOfLotto)
    printInfomationOnLottoPurchased(lottoNumbers)

    printLastWeekWinningNumbersReqeust()
    val winningStatistics =
        LottoWinningChecker(InputView.getLastWeekWinningNumbers())
            .getWinningStatistics(lottoNumbers)
    printWinningStatistics(winningStatistics)
    printRateOfReturn(RateOfReturn.get(numberOfLotto, winningStatistics.getTotalPrize()))
}
