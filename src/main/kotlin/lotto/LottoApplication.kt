package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoTicketRandomGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseMoney = InputView.getPurchaseMoney()
    val ticketCount = purchaseMoney / 1000
    OutputView.printPurchaseTicketCount(ticketCount)
    val lottoTickets = LottoMachine.issueLottoTickets(purchaseMoney, LottoTicketRandomGenerator)
    OutputView.printLottoTickets(lottoTickets)
}
