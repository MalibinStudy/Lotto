package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()
    val ticketCount = LottoMachine.getAmountOfLottoTickets(purchaseMoney)
    OutputView.printPurchaseTicketCount(ticketCount)
    val lottoTickets = LottoMachine.issueLottoTickets(purchaseMoney)
    OutputView.printLottoTickets(lottoTickets)
    val winningNumbers = InputView.getWinningNumbers()
    val winningStatics = lottoTickets.getWinningStatics(winningNumbers)
    OutputView.printWinningStatics(winningStatics)
}
