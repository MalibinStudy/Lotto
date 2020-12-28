package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoShop
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val lottoShop = LottoShop(LottoMachine())
    val lottoTickets = lottoShop.sellsLottoTickets(purchasePrice)
    OutputView.printMyLotto(lottoTickets)

    val winningNumberList = InputView.getWinningTicket()
    val prizeCheckList = lottoTickets.check(winningNumberList)
    OutputView.printMyLottoResult(prizeCheckList)
    OutputView.printMyGainRate(purchasePrice, prizeCheckList)
}
