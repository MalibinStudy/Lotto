package lotto

import lotto.domain.LottoTicketDispenser
import lotto.domain.LottoTicketGenerator
import lotto.domain.RevenueRatio
import lotto.domain.StatisticalGenerator
import lotto.view.InputView
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
    val lastWeekWinningTicket = InputView.getWinningLottoTicket()
    val lottoStatistics = StatisticalGenerator(lottoTickes).getStatisticsUse(lastWeekWinningTicket)
    printLottoStatistics(lottoStatistics)

    printRevenueRatio(RevenueRatio.calculate(money, lottoStatistics.getTotalPrize()))
}
