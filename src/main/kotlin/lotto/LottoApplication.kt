package lotto

import lotto.domain.DrawingMachine
import lotto.domain.LottoShop
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_END
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_START
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val lottoTickets = LottoShop()
        .installDrawingMachine(DrawingMachine((LOTTO_NUMBER_START..LOTTO_NUMBER_END)))
        .sellsLottoTickets(purchasePrice)
    OutputView.printMyLotto(lottoTickets)

    val winningNumberList = InputView.getWinningNumber()
    val prizeCheckList = lottoTickets.check(winningNumberList)
    OutputView.printMyLottoResult(prizeCheckList)
    OutputView.printMyGainRate(purchasePrice, prizeCheckList)
}
