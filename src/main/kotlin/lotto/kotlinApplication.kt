package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoTicketDispenser
import lotto.domain.LottoTicketGenerator
import lotto.domain.RevenueRatio
import lotto.view.InputView
import lotto.view.printBonusNumberRequest
import lotto.view.printInfomationOnLottoPurchased
import lotto.view.printLastWeekWinningNumbersReqeust
import lotto.view.printLottoStatistics
import lotto.view.printPurchaseAmountReqeust
import lotto.view.printRevenueRatio

fun main() {
    printPurchaseAmountReqeust()
    val money = InputView.getLottoPurchasedCount()
    val lottoTickes = LottoTicketDispenser(LottoTicketGenerator()).getLottoTickets(money)
    printInfomationOnLottoPurchased(lottoTickes)

    printLastWeekWinningNumbersReqeust()
    val lastWeekWinningTicket = LottoTicketGenerator.makeLottoTicket(InputView.getWinningLottoTicket())
    printBonusNumberRequest()
    val bonusNumber = LottoNumber.valueOf(InputView.getBonusNumber())
    val lottoStatistics = lottoTickes.getStatistics(lastWeekWinningTicket, bonusNumber)
    printLottoStatistics(lottoStatistics)

    printRevenueRatio(RevenueRatio.calculate(money, lottoStatistics.getTotalPrize()))
}
